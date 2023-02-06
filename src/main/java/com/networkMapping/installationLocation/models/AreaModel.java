package com.networkMapping.installationLocation.models;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.networkMapping.installationLocation.domain.Area;

@Entity
@Table(name = "area")
public class AreaModel {
    @Id
    public String id;

    public String name;

    @OneToMany
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public List<SubAreaModel> subAreas;

    public AreaModel() {
    }

    public AreaModel(UUID id, String name) {
        this.id = id.toString();
        this.name = name;
    }

    public AreaModel(Area area) {
        this.id = area.getId().toString();
        this.name = area.getName();
    }

    public Area toArea() {
        return new Area(UUID.fromString(this.id), this.name, null);
    }
}
