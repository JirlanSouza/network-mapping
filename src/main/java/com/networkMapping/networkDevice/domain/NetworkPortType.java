package com.networkMapping.networkDevice.domain;

import java.util.UUID;

public class NetworkPortType {
    public UUID getId() {
        return id;
    }

    public int getSpeed() {
        return speed;
    }

    public DataSpeedUnit getSpeedUnit() {
        return speedUnit;
    }

    private final UUID id;

    private final String name;
    private final int speed;
    private final DataSpeedUnit speedUnit;
    public NetworkPortType(String name, int speed, DataSpeedUnit speedUnit) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.speed = speed;
        this.speedUnit = speedUnit;
    }

    public NetworkPortType(UUID id, String name, int speed, DataSpeedUnit speedUnit) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.speedUnit = speedUnit;
    }

    public String getName() {
        return name;
    }
}
