package com.networkMapping.installationLocation.ormEntities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.networkMapping.installationLocation.domain.Area;

@Entity
public class AreaOrmEntity {
    @Id
    public UUID id;

    public String name;

    public AreaOrmEntity() {
    }

    public AreaOrmEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public AreaOrmEntity(Area area) {
        this.id = area.getId();
        this.name = area.getName();
    }
}
