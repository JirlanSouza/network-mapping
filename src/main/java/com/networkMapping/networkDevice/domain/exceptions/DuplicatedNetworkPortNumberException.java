package com.networkMapping.networkDevice.domain.exceptions;

public class DuplicatedNetworkPortNumberException extends RuntimeException {
    public DuplicatedNetworkPortNumberException(String message) {
        super(message);
    }
}
