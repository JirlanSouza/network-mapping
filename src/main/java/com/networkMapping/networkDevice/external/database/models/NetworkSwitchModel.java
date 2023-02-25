package com.networkMapping.networkDevice.external.database.models;

import com.networkMapping.networkDevice.domain.NetworkSwitch;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "network_switch")
public class NetworkSwitchModel {
    @Id
    UUID id;

    @Column(unique = true)
    String identificationTag;

    String brand;

    String model;

    @OneToMany
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    List<NetworkPortModel> ports;
    UUID installationLocalId;

    public NetworkSwitchModel(NetworkSwitch networkSwitch) {
        this.identificationTag = networkSwitch.getIdentificationTag();
        this.id = networkSwitch.getId();
        this.brand = networkSwitch.getBrand();
        this.model = networkSwitch.getModel();
        this.installationLocalId = networkSwitch.getInstallationLocalId();
    }
    public NetworkSwitchModel() {
    }
}
