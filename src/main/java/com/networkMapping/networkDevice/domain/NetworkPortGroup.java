package com.networkMapping.networkDevice.domain;

public record NetworkPortGroup(int startNumber, int endNumber, NetworkPortType port) {
}
