package com.networkMapping.networkDevice.domain.entities;

import com.networkMapping.networkDevice.domain.exceptions.InvalidNetworkPortConnection;
import com.networkMapping.networkDevice.domain.valueObjects.NetworkPortStatus;

import java.util.UUID;

public class NetworkPort {
    private final UUID id;
    private final int number;
    private final NetworkPortType type;
    private NetworkPortStatus status = NetworkPortStatus.DISCONNECTED;

    public NetworkPort(int number, NetworkPortType type) {
        this.id = UUID.randomUUID();
        this.number = number;
        this.type = type;
    }

    public NetworkPort(UUID id, int number, NetworkPortType type, NetworkPortStatus status) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.status = status;
    }

    public void connect(NetworkPort that) {
        validateStatusToConnection();
        that.validateStatusToConnection();

        status = NetworkPortStatus.CONNECTED;
        that.status = NetworkPortStatus.CONNECTED;
    }

    private void validateStatusToConnection() {
        if (status == NetworkPortStatus.CONNECTED) {
            throw new InvalidNetworkPortConnection("connection is not allowed: the network port is already connected");
        }

        if (status == NetworkPortStatus.FAULT) {
            throw new InvalidNetworkPortConnection("connection is not allowed: the network port is faulted");
        }
    }

    public UUID getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public NetworkPortType getType() {
        return type;
    }

    public NetworkPortStatus getStatus() {
        return status;
    }
}
