package com.networkMapping.installationLocation.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.networkMapping.installationLocation.domain.Area;

@Entity
@Table(name = "area")
public class AreaModel {
    @Id
    public UUID id;

    public String name;

    public AreaModel() {
    }

    public AreaModel(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public AreaModel(Area area) {
        this.id = area.getId();
        this.name = area.getName();
    }

    public Area toArea() {
        return new Area(this.id, this.name, null);
    }
}
