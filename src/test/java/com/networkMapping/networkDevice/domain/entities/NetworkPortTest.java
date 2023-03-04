package com.networkMapping.networkDevice.domain.entities;

import com.networkMapping.networkDevice.domain.exceptions.InvalidNetworkPortConnectionException;
import com.networkMapping.networkDevice.domain.valueObjects.DataSpeedUnit;
import com.networkMapping.networkDevice.domain.valueObjects.NetworkPortStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkPortTest {
    @Test
    public void ShouldCreateNewNetworkPort() {
        var portNumber = 1;
        var portType = new NetworkPortType("ethernet", 100, DataSpeedUnit.MBPS);
        var port = new NetworkPort(portNumber, portType);

        assertNotNull(port.getId());
        assertEquals(port.getNumber(), portNumber);
        assertEquals(port.getType(), portType);
        assertEquals(port.getStatus(), NetworkPortStatus.DISCONNECTED);
    }

    @Test
    public void shouldConnectNetworkPort() {
        var portType = new NetworkPortType("ethernet", 100, DataSpeedUnit.MBPS);
        var port1 = new NetworkPort(1, portType);
        var port2 = new NetworkPort(2, portType);

        port1.connect(port2);

        assertEquals(port1.getStatus(), NetworkPortStatus.CONNECTED);
        assertEquals(port2.getStatus(), NetworkPortStatus.CONNECTED);
    }

    @Test
    public void shouldNotConnectNetworkPortAlreadyConnected() {
        var portType = new NetworkPortType("ethernet", 100, DataSpeedUnit.MBPS);
        var port1 = new NetworkPort(1, portType);
        var port2 = new NetworkPort(2, portType);
        var port3 = new NetworkPort(3, portType);
        port1.connect(port2);

        assertThrows(InvalidNetworkPortConnectionException.class, () -> port3.connect(port1));
    }
}