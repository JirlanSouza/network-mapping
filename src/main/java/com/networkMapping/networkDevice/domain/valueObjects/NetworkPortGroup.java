package com.networkMapping.networkDevice.domain.valueObjects;

import com.networkMapping.networkDevice.domain.entities.NetworkPortType;

public record NetworkPortGroup(int startNumber, int endNumber, NetworkPortType port) {
}
