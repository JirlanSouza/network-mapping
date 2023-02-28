package com.networkMapping.networkDevice.application.useCases;

import com.networkMapping.networkDevice.application.dtos.GetNetworkSwitchDto;
import com.networkMapping.networkDevice.application.repositories.NetworkDeviceRepository;
import com.networkMapping.shared.exceptions.NotFoundEntityException;

import java.util.UUID;

public class GetNetworkSwitchUseCase {
    private final NetworkDeviceRepository networkDeviceRepository;

    public GetNetworkSwitchUseCase(NetworkDeviceRepository networkDeviceRepository) {
        this.networkDeviceRepository = networkDeviceRepository;
    }

    public GetNetworkSwitchDto execute(UUID id) {
        return networkDeviceRepository.getSwitchSummary(id)
            .orElseThrow(() -> new NotFoundEntityException(
                "the network switch with id: %S does not exists".formatted(id))
            );
    }
}
