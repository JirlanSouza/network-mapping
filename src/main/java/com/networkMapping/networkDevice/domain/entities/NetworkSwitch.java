package com.networkMapping.networkDevice.domain.entities;

import com.networkMapping.networkDevice.domain.exceptions.DuplicatedNetworkPortNumberException;
import com.networkMapping.networkDevice.domain.exceptions.InvalidNetworkSwitchConnectionException;
import com.networkMapping.networkDevice.domain.valueObjects.NetworkPortGroup;
import com.networkMapping.networkDevice.domain.valueObjects.NetworkSwitchLayer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class NetworkSwitch implements NetworkConnectable {
    private final UUID id;
    private String identificationTag;
    private String brand;
    private String model;
    private final List<NetworkPort> ports;
    private final UUID installationLocalId;
    private NetworkSwitchLayer layer;

    public NetworkSwitch(
        String identificationTag,
        String brand,
        String model,
        UUID installationLocalId,
        NetworkSwitchLayer layer
    ) {
        this.id = UUID.randomUUID();
        this.identificationTag = identificationTag;
        this.brand = brand;
        this.model = model;
        this.ports = new ArrayList<NetworkPort>();
        this.installationLocalId = installationLocalId;
        this.layer = layer;
    }

    public void addPorts(NetworkPortGroup portGroup) {
        portGroup.createPorts().forEach(this::addPort);
    }

    private void addPort(NetworkPort port) {
        var existingPortsWithEqualNumber = ports.stream().anyMatch(
            currentPort -> currentPort.getNumber() == port.getNumber()
        );

        if (existingPortsWithEqualNumber) {
            throw new DuplicatedNetworkPortNumberException(
                "duplicated network portType number: %d on network switch".formatted(
                    port.getNumber())
            );
        }

        ports.add(port);
    }

    public void validateConnection(NetworkConnectable that) {
        if (that instanceof NetworkSwitch) {
            validateLayerConnection((NetworkSwitch) that);
        }
    }

    private void validateLayerConnection(NetworkSwitch that) {

        if (!layer.acceptableConnection(that.getLayer())) {
            throw new InvalidNetworkSwitchConnectionException(
                "the network switch connection does not permitted with network switch with layer %s"
                    .formatted(layer.name())
            );
        }
    }
}
