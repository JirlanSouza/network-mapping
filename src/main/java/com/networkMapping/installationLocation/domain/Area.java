package com.networkMapping.installationLocation.domain;

import java.util.List;
import java.util.UUID;

public class Area {
    private UUID id;
    private String name;
    private List<SubArea> subAreas;

    public Area(String name, List<SubArea> subAreas) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.subAreas = subAreas;
    }

    public Area(UUID id, String name, List<SubArea> subAreas) {
        this.id = id;
        this.name = name;
        this.subAreas = subAreas;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<SubArea> getSubAreas() {
        return subAreas;
    }
}
