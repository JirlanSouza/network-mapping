package com.networkMapping.networkDevice.external.database.models;

import com.networkMapping.networkDevice.domain.NetworkPort;
import com.networkMapping.networkDevice.domain.NetworkPortStatus;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "network_port")
public class NetworkPortModel {
    @Id
    UUID id;
    int number;

    @Column(name = "port_type")
    UUID portTypeId;

    @ManyToOne
    @JoinColumn(name = "port_type_id", referencedColumnName = "id")
    NetworkPortTypeModel portType;

    @Column(name = "parent_id")
    UUID parentId;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    NetworkPortStatus status;

    public NetworkPortModel(NetworkPort port, UUID parentId) {
        this.id = port.getId();
        this.number = port.getNumber();
        this.portTypeId = port.getType().getId();
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

    public UUID getPortTypeId() {
        return portTypeId;
    }

    public void setPortTypeId(UUID portTypeId) {
        this.portTypeId = portTypeId;
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
