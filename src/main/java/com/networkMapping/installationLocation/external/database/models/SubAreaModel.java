package com.networkMapping.installationLocation.external.database.models;

import com.networkMapping.installationLocation.domain.entities.SubArea;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "sub_area")
public class SubAreaModel {
    @Id
    public UUID id;

    public String name;

    @Column(name = "parent_id")
    public UUID parentId;

    public SubAreaModel() {
    }

    public SubAreaModel(SubArea subArea) {
        this.id = subArea.getId();
        this.name = subArea.getName();
        this.parentId = subArea.getParentId();
    }

    public SubArea toSubArea() {
        return new SubArea(id, name, parentId);
    }
}
