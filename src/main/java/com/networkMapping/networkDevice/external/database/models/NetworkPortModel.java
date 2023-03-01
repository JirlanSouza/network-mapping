package com.networkMapping.networkDevice.external.database.models;

import com.networkMapping.networkDevice.domain.entities.NetworkPort;
import com.networkMapping.networkDevice.domain.valueObjects.NetworkPortStatus;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "network_port")
public class NetworkPortModel {
    @Id
    UUID id;
    int number;

    @ManyToOne
    @JoinColumn(name = "port_type", referencedColumnName = "id")
    NetworkPortTypeModel portType;

    @Column(name = "parent_id")
    UUID parentId;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    NetworkPortStatus status;

    public NetworkPortModel(NetworkPort port, UUID parentId) {
        this.id = port.getId();
        this.number = port.getNumber();
        this.portType = new NetworkPortTypeModel(port.getType());
        this.parentId = parentId;
        this.status = port.getStatus();
    }

    public NetworkPortModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public NetworkPortTypeModel getPortType() {
        return portType;
    }

    public void setPortType(NetworkPortTypeModel portType) {
        this.portType = portType;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    public NetworkPortStatus getStatus() {
        return status;
    }

    public void setStatus(NetworkPortStatus status) {
        this.status = status;
    }
}
