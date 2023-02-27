package com.networkMapping.networkDevice.external.database.models;

import com.networkMapping.networkDevice.domain.DataSpeedUnit;
import com.networkMapping.networkDevice.domain.NetworkPortType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(
    name = "network_port_type",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "speed", "speedUnit"})}
)
public class NetworkPortTypeModel {
    @Id
    UUID id;
    private String name;
    private int speed;
    @Enumerated(EnumType.STRING)
    private DataSpeedUnit speedUnit;

    public NetworkPortTypeModel(NetworkPortType portType) {
        this.id = portType.getId();
        this.name = portType.getName();
        this.speed = portType.getSpeed();
        this.speedUnit = portType.getSpeedUnit();
    }

    public NetworkPortTypeModel() {
    }

    public NetworkPortType toEntity() {
        return new NetworkPortType(id, name, speed, speedUnit);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public DataSpeedUnit getSpeedUnit() {
        return speedUnit;
    }

    public void setSpeedUnit(DataSpeedUnit speedUnit) {
        this.speedUnit = speedUnit;
    }
}
