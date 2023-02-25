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

    UUID portTypeId;

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
}
