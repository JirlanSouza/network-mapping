package com.networkMapping.networkDevice.domain.errors;

public class DuplicatedNetworkPortNumberException extends RuntimeException {
    public DuplicatedNetworkPortNumberException(String message) {
        super(message);
    }
}
