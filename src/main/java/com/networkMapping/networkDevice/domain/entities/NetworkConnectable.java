package com.networkMapping.networkDevice.domain.entities;

public interface NetworkConnectable {
    void validateConnection(NetworkConnectable that);

    default void connect(NetworkConnectable that) {
        validateConnection(that);
    }
}
