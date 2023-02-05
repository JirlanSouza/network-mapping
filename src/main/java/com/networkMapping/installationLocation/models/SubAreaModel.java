package com.networkMapping.installationLocation.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sub_area")
public class SubAreaModel {
    @Id
    public UUID id;

    public String name;

    @Column(name = "parent_id")
    public UUID parentId;
}
