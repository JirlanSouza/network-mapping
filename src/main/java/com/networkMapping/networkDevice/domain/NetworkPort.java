package com.networkMapping.networkDevice.domain;

import java.util.UUID;

public class NetworkPort {
    private final UUID id;
    private final int number;
    private final NetworkPortPhysicalType type;
    private final int speed;
    private NetworkPortStatus status = NetworkPortStatus.DISCONNECTED;

    public NetworkPort(int number, NetworkPortPhysicalType type, int speed) {
        this.id = UUID.randomUUID();
        this.number = number;
        this.type = type;
        this.speed = speed;
    }

    public NetworkPort(UUID id, int number, NetworkPortPhysicalType type, int speed, NetworkPortStatus status) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.speed = speed;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public NetworkPortPhysicalType getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public NetworkPortStatus getStatus() {
        return status;
    }

    public void setStatus(NetworkPortStatus status) {
        this.status = status;
    }
}
