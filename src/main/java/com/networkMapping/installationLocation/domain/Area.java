package com.networkMapping.installationLocation.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Area {
    private final UUID id;
    private String name;

    private final List<SubArea> subAreas;
    public Area(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.subAreas = new ArrayList<SubArea>();
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public List<SubArea> getSubAreas() {
        return subAreas;
    }
}
