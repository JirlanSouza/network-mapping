package com.networkMapping.installationLocation.domain;

import com.networkMapping.installationLocation.domain.exceptions.InvalidSubAreaIdException;

import java.util.UUID;

public class SubArea {
    private UUID id;
    private String name;
    private UUID parentId;

    public SubArea(String name, UUID parentId) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.parentId = parentId;
    }

    public SubArea(UUID id, String name, UUID parentId) {
        if (id.equals(parentId)) {
            throw new InvalidSubAreaIdException("subarea id and parent id cannot be the same");
        }
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
