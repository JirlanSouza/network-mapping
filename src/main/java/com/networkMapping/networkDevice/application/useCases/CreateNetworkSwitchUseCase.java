package com.networkMapping.networkDevice.application.useCases;

import com.networkMapping.installationLocation.application.repositories.SubAreaRepository;
import com.networkMapping.networkDevice.application.dtos.CreateNetworkSwitchDto;
import com.networkMapping.networkDevice.application.dtos.CreateNetworkSwitchPortDto;
import com.networkMapping.networkDevice.application.repositories.NetworkDeviceRepository;
import com.networkMapping.networkDevice.domain.NetworkPortGroup;
import com.networkMapping.networkDevice.domain.NetworkSwitch;
import com.networkMapping.shared.exceptions.NotFoundEntityException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateNetworkSwitchUseCase {
    private final NetworkDeviceRepository networkDeviceRepository;
    private final SubAreaRepository subAreaRepository;

    public CreateNetworkSwitchUseCase(
        NetworkDeviceRepository networkDeviceRepository, SubAreaRepository areaRepository
    ) {
        this.networkDeviceRepository = networkDeviceRepository;
        this.subAreaRepository = areaRepository;
    }

    public UUID execute(CreateNetworkSwitchDto networkSwitchDto) {
        var existsInstallationLocal = subAreaRepository.exists(networkSwitchDto.installationLocalId());

        if (!existsInstallationLocal) {
            throw new NotFoundEntityException("installation local with id: %s does not exists".formatted(
                networkSwitchDto.installationLocalId())
            );
        }

        var portsType = networkSwitchDto.ports().stream().map(this::getPortsTypes).toList();

        var networkSwitch = new NetworkSwitch(
            networkSwitchDto.identificationTag(),
            networkSwitchDto.brand(),
            networkSwitchDto.model(),
            networkSwitchDto.installationLocalId()
        );

        portsType.forEach(networkSwitch::addPorts);
        networkDeviceRepository.saveSwitch(networkSwitch);

        return networkSwitch.getId();
    }

    private NetworkPortGroup getPortsTypes(CreateNetworkSwitchPortDto portDto) {
        var
            portType = networkDeviceRepository.getPortType(portDto.portTypeId())
            .orElseThrow(() -> new NotFoundEntityException(
                    "the network port type with id: %s does not exists".formatted(
                        portDto.portTypeId())
                )
            );

        return new NetworkPortGroup(portDto.startNumber(), portDto.endNumber(), portType);
    }
}
