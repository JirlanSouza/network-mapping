package com.networkMapping.networkDevice.domain.valueObjects;

import com.networkMapping.networkDevice.domain.entities.NetworkPortType;
import com.networkMapping.networkDevice.domain.exceptions.InvalidNetworkPortSequence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkPortGroupTest {
    @Test
    public void shouldBeNotCreateNetworkPortGroupWithInvalidSequence() {
        var startNumber = 3;
        var endNumber = 1;
        var portType = new NetworkPortType("ethernet", 100, DataSpeedUnit.MBPS);

        assertThrows(InvalidNetworkPortSequence.class, () -> new NetworkPortGroup(startNumber, endNumber, portType));
    }

    @Test
    public void shouldBeCreatePortsWithSequenceNumbers() {
        var portType = new NetworkPortType("ethernet", 100, DataSpeedUnit.MBPS);
        var portsGroup = new NetworkPortGroup(1, 3, portType);

        var ports = portsGroup.createPorts().toList();

        assertEquals(ports.size(), 3);
        assertEquals(ports.get(0).getNumber(), 1);
        assertEquals(ports.get(1).getNumber(), 2);
        assertEquals(ports.get(2).getNumber(), 3);
        assertTrue(ports.stream().allMatch(port -> port.getType().equals(portType)));
    }
}