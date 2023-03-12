package com.networkMapping.networkDevice.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NetworkDevice {
    private final UUID id;
    private String identificationTag;
    private String description;
    private String type;
    private String brand;
    private String model;
    private List<NetworkPort> ports = new ArrayList<NetworkPort>();

    public NetworkDevice(String identificationTag, String description, String type, String brand, String model) {
        this.id = UUID.randomUUID();
        this.identificationTag = identificationTag;
        this.description = description;
        this.type = type;
        this.brand = brand;
        this.model = model;
    }

    public NetworkDevice(
        UUID id,
        String identificationTag,
        String description,
        String type,
        String brand,
        String model,
        List<NetworkPort> ports
    ) {
        this.id = id;
        this.identificationTag = identificationTag;
        this.description = description;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.ports = ports;
    }
}
