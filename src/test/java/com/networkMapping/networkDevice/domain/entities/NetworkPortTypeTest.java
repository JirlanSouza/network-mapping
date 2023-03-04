package com.networkMapping.networkDevice.domain.entities;

import com.networkMapping.networkDevice.domain.exceptions.InvalidDataSpeedValue;
import com.networkMapping.networkDevice.domain.valueObjects.DataSpeedUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkPortTypeTest {
    @Test
    public void shouldBeCreateNewNetworkPortType() {
        var name = "ethernet";
        var speed = 100;
        var speedUnit = DataSpeedUnit.MBPS;
        var portType = new NetworkPortType(name, speed, speedUnit);

        assertNotNull(portType.getId());
        assertEquals(portType.getName(), name);
        assertEquals(portType.getSpeed(), speed);
        assertEquals(portType.getSpeedUnit(), speedUnit);
    }

    @Test
    public void shouldNotCreateNetworkPortTypeWithInvalidSpeed() {
        var name = "ethernet";
        var speed = -1;
        var speedUnit = DataSpeedUnit.MBPS;

        assertThrows(InvalidDataSpeedValue.class, () -> new NetworkPortType(name, speed, speedUnit));
    }
}