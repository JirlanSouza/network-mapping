package com.networkMapping.networkDevice.domain.entities;

import com.networkMapping.networkDevice.domain.valueObjects.DataSpeedUnit;
import com.networkMapping.networkDevice.domain.valueObjects.NetworkPortGroup;
import com.networkMapping.networkDevice.domain.valueObjects.NetworkPortStatus;
import com.networkMapping.networkDevice.domain.valueObjects.NetworkSwitchLayer;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class NetworkSwitchTest {
    @Test
    public void shouldCreateNewNetworkSwitch() {
        var identificationTag = "SW001";
        var brand = "Cisco";
        var model = "SWG9999";
        var installationLocalId = UUID.randomUUID();
        var layer = NetworkSwitchLayer.LAYER2;

        var networkSwitch = new NetworkSwitch(identificationTag, brand, model, installationLocalId, layer);

        assertNotNull(networkSwitch.getId());
        assertEquals(networkSwitch.getIdentificationTag(), identificationTag);
        assertEquals(networkSwitch.getBrand(), brand);
        assertEquals(networkSwitch.getModel(), model);
        assertEquals(networkSwitch.getInstallationLocalId(), installationLocalId);
        assertEquals(networkSwitch.getLayer(), layer);
        assertEquals(networkSwitch.getPorts().size(), 0);
    }

    @Test
    public void shouldAddPorts() {
        var identificationTag = "SW001";
        var brand = "Cisco";
        var model = "SWG9999";
        var installationLocalId = UUID.randomUUID();
        var layer = NetworkSwitchLayer.LAYER2;
        var networkSwitch = new NetworkSwitch(identificationTag, brand, model, installationLocalId, layer);
        var portType = new NetworkPortType("ethernet", 100, DataSpeedUnit.MBPS);
        var portsGroup = new NetworkPortGroup(1,4, portType);

        networkSwitch.addPorts(portsGroup);
        var ports = networkSwitch.getPorts();

        assertEquals(ports.size(), 4);

        ports.forEach(port -> {
            assertEquals(port.getStatus(), NetworkPortStatus.DISCONNECTED);
            assertEquals(port.getType(), portType);
        });
    }
}