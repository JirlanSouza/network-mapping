package com.networkMapping.networkDevice.domain.valueObjects;

import com.networkMapping.networkDevice.domain.entities.NetworkPort;
import com.networkMapping.networkDevice.domain.entities.NetworkPortType;
import com.networkMapping.networkDevice.domain.exceptions.InvalidNetworkPortSequence;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public record NetworkPortGroup(int startNumber, int endNumber, NetworkPortType portType) {
    public NetworkPortGroup {
        validateSequenceNumbers(startNumber, endNumber);
    }

    public Stream<NetworkPort> createPorts() {
        return IntStream.range(startNumber, endNumber + 1)
            .mapToObj(i -> new NetworkPort(i, portType));
    }

    private void validateSequenceNumbers(int startNumber, int endNumber) {
        if (startNumber <= endNumber) {
            return;
        }

        throw new InvalidNetworkPortSequence("invalid ports sequence from: %d to: %d".formatted(
            startNumber,
            endNumber
        ));
    }
}
