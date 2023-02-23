package com.networkMapping.networkDevice.external.database.models;

import java.io.Serializable;
import java.util.Objects;

public class NetworkPortTypeModelId implements Serializable {
    private String name;
    private int speed;

    public NetworkPortTypeModelId(String physicalType, int speed) {
        this.name = physicalType;
        this.speed = speed;
    }

    public NetworkPortTypeModelId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetworkPortTypeModelId that = (NetworkPortTypeModelId) o;
        return speed == that.speed && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, speed);
    }
}
