package com.networkMapping.networkDevice.domain;

import com.networkMapping.networkDevice.domain.exceptions.InvalidNetworkPortSequence;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NetworkSwitch {
    private final UUID id;
    private String identificationTag;
    private String brand;
    private String model;
    private final List<NetworkPort> ports;
    private final UUID installationLocalId;

    public NetworkSwitch(
        UUID id,
        String identificationTag,
        String brand,
        String model,
        List<NetworkPort> ports,
        UUID installationLocalId
    ) {
        this.id = id;
        this.identificationTag = identificationTag;
        this.brand = brand;
        this.model = model;
        this.ports = ports;
        this.installationLocalId = installationLocalId;
    }

    public NetworkSwitch(String identificationTag, String brand, String model, UUID installationLocalId) {
        this.id = UUID.randomUUID();
        this.identificationTag = identificationTag;
        this.brand = brand;
        this.model = model;
        this.ports = new ArrayList<NetworkPort>();
        this.installationLocalId = installationLocalId;
    }

    public void addPorts(NetworkPortGroup portGroup) {
        if (portGroup.startNumber() > portGroup.endNumber()) {
            throw new InvalidNetworkPortSequence(
                "invalid ports sequence from: %d to: %d".formatted(
                    portGroup.startNumber(),
                    portGroup.endNumber()
                )
            );
        }

        for (int i = portGroup.startNumber(); i <= portGroup.endNumber(); i++) {
            ports.add(new NetworkPort(i, portGroup.port()));
        }
    }

    public UUID getId() {
        return id;
    }

    public String getIdentificationTag() {
        return identificationTag;
    }

    public void setIdentificationTag(String identificationTag) {
        this.identificationTag = identificationTag;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<NetworkPort> getPorts() {
        return ports;
    }

    public UUID getInstallationLocalId() {
        return installationLocalId;
    }
}
