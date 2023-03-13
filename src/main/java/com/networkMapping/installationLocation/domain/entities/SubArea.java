package com.networkMapping.installationLocation.domain.entities;

import com.networkMapping.installationLocation.domain.exceptions.InvalidSubAreaIdException;
import com.networkMapping.installationLocation.domain.valueObjects.LocationName;
import lombok.Getter;

import java.util.UUID;

@Getter
public class SubArea {
    private final UUID id;
    private LocationName name;
    private UUID parentId;

    public SubArea(String name, UUID parentId) {
        this.id = UUID.randomUUID();
        this.name = new LocationName(name);
        this.parentId = parentId;
    }

    public SubArea(UUID id, String name, UUID parentId) {
        if (id.equals(parentId)) {
            throw new InvalidSubAreaIdException("subarea id and parent id cannot be the same");
        }
        this.id = id;
        this.name = new LocationName(name);
        this.parentId = parentId;
    }

    public String getName() {
        return name.value();
    }

    public void setName(String name) {
        this.name = new LocationName(name);
    }
}
