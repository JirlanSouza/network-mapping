package com.networkMapping.installationLocation.domain;

import java.util.UUID;

public class SubArea {
    private UUID Id;
    private String name;

    public SubArea(String name) {
        this.Id = UUID.randomUUID();
        this.name = name;
    }

    public SubArea(UUID id, String name) {
        Id = id;
        this.name = name;
    }

    public UUID getId() {
        return Id;
    }

    public String getName() {
        return name;
    }
}
