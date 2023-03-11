package com.networkMapping.networkDevice.application.useCases;

import com.networkMapping.networkDevice.application.repositories.NetworkDeviceRepository;
import com.networkMapping.networkDevice.domain.entities.NetworkPortType;
import com.networkMapping.shared.exceptions.AlreadyExistsEntityException;
import com.networkMapping.shared.logger.ApplicationLogger;
import com.networkMapping.shared.logger.ApplicationLoggerFactory;


public class CreateNetworkPortTypeUseCase {
    private final ApplicationLogger logger;
    private final NetworkDeviceRepository networkDeviceRepository;

    public CreateNetworkPortTypeUseCase(
        NetworkDeviceRepository networkDeviceRepository,
        ApplicationLoggerFactory loggerFactory
    ) {
        this.networkDeviceRepository = networkDeviceRepository;
        this.logger = loggerFactory.getLogger(CreateNetworkPortTypeUseCase.class);
    }

    public NetworkPortType execute(NetworkPortType networkPortType) {
        var existsNetworkPortType = networkDeviceRepository.existsPortType(networkPortType);

        if (existsNetworkPortType) {
            throw new AlreadyExistsEntityException("the network portType type already exists");
        }

        networkDeviceRepository.savePortType(networkPortType);
        logger.info("created the new network port type with id: %s".formatted(networkPortType.getId()));
        return networkPortType;
    }
}
