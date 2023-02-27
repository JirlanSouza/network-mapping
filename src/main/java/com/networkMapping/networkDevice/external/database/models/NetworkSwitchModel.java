package com.networkMapping.networkDevice.external.database.models;

import com.networkMapping.installationLocation.external.database.models.SubAreaModel;
import com.networkMapping.networkDevice.domain.NetworkSwitch;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "network_switch")
public class NetworkSwitchModel {
    @Id
    private UUID id;

    @Column(unique = true)
    private String identificationTag;

    private String brand;

    private String model;

    @OneToMany
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private List<NetworkPortModel> ports;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private SubAreaModel installationLocal;

    public NetworkSwitchModel(NetworkSwitch networkSwitch) {
        this.identificationTag = networkSwitch.getIdentificationTag();
        this.id = networkSwitch.getId();
        this.brand = networkSwitch.getBrand();
        this.model = networkSwitch.getModel();
        this.installationLocal = new SubAreaModel();
        this.installationLocal.id = networkSwitch.getInstallationLocalId();
    }
    public NetworkSwitchModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public List<NetworkPortModel> getPorts() {
        return ports;
    }

    public void setPorts(List<NetworkPortModel> ports) {
        this.ports = ports;
    }

    public SubAreaModel getInstallationLocal() {
        return installationLocal;
    }

    public void setInstallationLocal(SubAreaModel installationLocal) {
        this.installationLocal = installationLocal;
    }
}
