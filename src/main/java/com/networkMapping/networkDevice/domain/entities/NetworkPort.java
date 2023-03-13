package com.networkMapping.networkDevice.domain.entities;

import com.networkMapping.networkDevice.domain.exceptions.InvalidNetworkPortConnectionException;
import com.networkMapping.networkDevice.domain.valueObjects.NetworkPortStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
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

    public void connect(NetworkPort that) {
        validateStatusToConnection();
        that.validateStatusToConnection();

        status = NetworkPortStatus.CONNECTED;
        that.status = NetworkPortStatus.CONNECTED;
    }

    private void validateStatusToConnection() {
        if (status == NetworkPortStatus.CONNECTED) {
            throw new InvalidNetworkPortConnectionException(
                "connection is not allowed: the network port is already connected");
        }

        if (status == NetworkPortStatus.FAULT) {
            throw new InvalidNetworkPortConnectionException("connection is not allowed: the network port is faulted");
        }
    }
}
