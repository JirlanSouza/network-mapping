package com.networkMapping.networkDevice.domain.entities;

import com.networkMapping.networkDevice.domain.valueObjects.DataSpeed;
import com.networkMapping.networkDevice.domain.valueObjects.DataSpeedUnit;
import lombok.Getter;

import java.util.UUID;

@Getter
public class NetworkPortType {
    private final UUID id;
    private final String name;
    private final DataSpeed speed;
    private final DataSpeedUnit speedUnit;

    public NetworkPortType(String name, int speed, DataSpeedUnit speedUnit) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.speed = new DataSpeed(speed);
        this.speedUnit = speedUnit;
    }

    public NetworkPortType(UUID id, String name, int speed, DataSpeedUnit speedUnit) {
        this.id = id;
        this.name = name;
        this.speed = new DataSpeed(speed);
        this.speedUnit = speedUnit;
    }

    public int getSpeed() {
        return speed.value();
    }
}
