package com.networkMapping.installationLocation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sub_area")
public class SubAreaModel {
    @Id
    public String id;

    public String name;

    @Column(name = "parent_id")
    public String parentId;
}
