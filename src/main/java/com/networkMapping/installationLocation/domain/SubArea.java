package com.networkMapping.installationLocation.domain;

import java.util.UUID;

public class SubArea {
    private UUID id;
    private String name;
    private UUID parentId;

    public SubArea(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public SubArea(UUID id, String name, UUID parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }
}
