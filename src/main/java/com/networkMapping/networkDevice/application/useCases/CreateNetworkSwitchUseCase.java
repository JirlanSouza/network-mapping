package com.networkMapping.networkDevice.application.useCases;

import com.networkMapping.installationLocation.application.repositories.SubAreaRepository;
import com.networkMapping.networkDevice.application.dtos.CreateNetworkSwitchDto;
import com.networkMapping.networkDevice.application.dtos.CreateNetworkSwitchPortDto;
import com.networkMapping.networkDevice.application.repositories.NetworkDeviceRepository;
import com.networkMapping.networkDevice.domain.entities.NetworkSwitch;
import com.networkMapping.networkDevice.domain.valueObjects.NetworkPortGroup;
import com.networkMapping.shared.exceptions.NotFoundEntityException;
import com.networkMapping.shared.logger.ApplicationLogger;
import com.networkMapping.shared.logger.ApplicationLoggerFactory;

import java.util.UUID;


public class CreateNetworkSwitchUseCase {
    private final NetworkDeviceRepository networkDeviceRepository;
    private final SubAreaRepository subAreaRepository;
    private final ApplicationLogger logger;

    public CreateNetworkSwitchUseCase(
        NetworkDeviceRepository networkDeviceRepository,
        SubAreaRepository areaRepository,
        ApplicationLoggerFactory loggerFactory
    ) {
        this.networkDeviceRepository = networkDeviceRepository;
        this.subAreaRepository = areaRepository;
        this.logger = loggerFactory.getLogger(CreateNetworkSwitchUseCase.class);
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
            networkSwitchDto.installationLocalId(),
            networkSwitchDto.layer()
        );

        portsType.forEach(networkSwitch::addPorts);
        networkDeviceRepository.saveSwitch(networkSwitch);

        logger.info("created the new network switch with id: %s".formatted(networkSwitch.getId()));
        return networkSwitch.getId();
    }

    private NetworkPortGroup getPortsTypes(CreateNetworkSwitchPortDto portDto) {
        var
            portType = networkDeviceRepository.getPortType(portDto.portTypeId())
            .orElseThrow(() -> new NotFoundEntityException(
                    "the network portType type with id: %s does not exists".formatted(
                        portDto.portTypeId())
                )
            );

        return new NetworkPortGroup(portDto.startNumber(), portDto.endNumber(), portType);
    }
}
