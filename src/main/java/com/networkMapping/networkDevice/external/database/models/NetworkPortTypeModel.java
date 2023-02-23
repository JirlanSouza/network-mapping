package com.networkMapping.networkDevice.external.database.models;

import com.networkMapping.networkDevice.domain.DataSpeedUnit;
import com.networkMapping.networkDevice.domain.NetworkPortType;
import jakarta.persistence.*;

@Entity
@Table(name = "network_port_type")
@IdClass(value = NetworkPortTypeModelId.class)
public class NetworkPortTypeModel {

    @Id
    private String name;
    @Id
    private int speed;
    @Enumerated(EnumType.STRING)
    private DataSpeedUnit speedUnit;

    public NetworkPortTypeModel(NetworkPortType portType) {
        this.name = portType.name();
        this.speed = portType.speed();
        this.speedUnit = portType.speedUnit();
    }

    public NetworkPortTypeModel() {

    }
}
