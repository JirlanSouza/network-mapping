package com.networkMapping.networkDevice.application.useCases;

import com.networkMapping.networkDevice.application.dtos.CreateNetworkSwitchDto;
import com.networkMapping.networkDevice.application.dtos.CreateSwitchPortDto;
import com.networkMapping.networkDevice.application.repositories.NetworkDeviceRepository;
import com.networkMapping.networkDevice.domain.NetworkPortGroup;
import com.networkMapping.networkDevice.domain.NetworkSwitch;
import com.networkMapping.shared.exceptions.NotFoundEntityException;

public class CreateNetworkSwitchUseCase {
    private final NetworkDeviceRepository networkDeviceRepository;

    public CreateNetworkSwitchUseCase(NetworkDeviceRepository networkDeviceRepository) {
        this.networkDeviceRepository = networkDeviceRepository;
    }

    public void execute(CreateNetworkSwitchDto networkSwitchDto) {
        var portsType = networkSwitchDto.ports()
            .stream().map(this::getPortsTypes).toList();

        var networkSwitch = new NetworkSwitch(
            networkSwitchDto.identificationTag(),
            networkSwitchDto.brand(),
            networkSwitchDto.model(),
            networkSwitchDto.installationLocalId()
        );

        portsType.forEach(networkSwitch::addPorts);
        networkDeviceRepository.saveSwitch(networkSwitch);
    }

    private NetworkPortGroup getPortsTypes(CreateSwitchPortDto portDto) {
        var portType = networkDeviceRepository.getPortType(
            portDto.portTypeId()
        ).orElseThrow(
            () -> new NotFoundEntityException(
                "the network port type with id: %s does not exists".formatted(
                    portDto.portTypeId()
                )
            )
        );

        return new NetworkPortGroup(portDto.startNumber(), portDto.endNumber(), portType);
    }
}