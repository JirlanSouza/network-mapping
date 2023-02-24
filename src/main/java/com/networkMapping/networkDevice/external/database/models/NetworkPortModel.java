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

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    NetworkPortStatus status;

    public NetworkPortModel(NetworkPort port) {
        this.id = port.getId();
        this.number = port.getNumber();
        this.portTypeId = port.getType().getId();
    }

    public NetworkPortModel() {
    }
}
