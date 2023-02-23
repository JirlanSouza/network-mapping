package com.networkMapping.networkDevice.application.useCases;

import com.networkMapping.networkDevice.application.repositories.NetworkDeviceRepository;
import com.networkMapping.networkDevice.domain.NetworkPortType;
import com.networkMapping.shared.exceptions.AlreadyExistsEntityException;
import org.springframework.stereotype.Service;

@Service
public class CreateNetworkPortTypeUseCase {
    private final NetworkDeviceRepository networkDeviceRepository;

    public CreateNetworkPortTypeUseCase(NetworkDeviceRepository networkDeviceRepository) {
        this.networkDeviceRepository = networkDeviceRepository;
    }

    public NetworkPortType execute(NetworkPortType networkPortType) {
        var existsNetworkPortType = networkDeviceRepository.existsPortType(networkPortType);

        if (existsNetworkPortType) {
            throw new AlreadyExistsEntityException("the network port type already exists");
        }

        networkDeviceRepository.savePortType(networkPortType);
        return networkPortType;
    }
}
