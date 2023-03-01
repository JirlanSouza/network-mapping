package com.networkMapping.networkDevice.domain.entities;

import com.networkMapping.networkDevice.domain.valueObjects.NetworkPortStatus;

import java.util.UUID;

public class NetworkPort {
    public UUID getId() {
        return id;
    }

    private final UUID id;
    private final int number;
    private final NetworkPortType type;
    private NetworkPortStatus status = NetworkPortStatus.DISCONNECTED;

    public NetworkPort(int number, NetworkPortType type) {
        this.id = UUID.randomUUID();
        this.number = number;
        this.type = type;
    }

    public NetworkPort(UUID id, int number, NetworkPortType type, NetworkPortStatus status) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public NetworkPortType getType() {
        return type;
    }

    public NetworkPortStatus getStatus() {
        return status;
    }

    public void setStatus(NetworkPortStatus status) {
        this.status = status;
    }
}
