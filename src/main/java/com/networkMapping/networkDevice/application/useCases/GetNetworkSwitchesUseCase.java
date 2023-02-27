package com.networkMapping.networkDevice.application.useCases;

import com.networkMapping.networkDevice.application.dtos.GetNetworkSwitchesDto;
import com.networkMapping.networkDevice.application.repositories.NetworkDeviceRepository;

import java.util.List;

public class GetNetworkSwitchesUseCase {
    private final NetworkDeviceRepository networkDeviceRepository;

    public GetNetworkSwitchesUseCase(NetworkDeviceRepository networkDeviceRepository) {
        this.networkDeviceRepository = networkDeviceRepository;
    }

    public List<GetNetworkSwitchesDto> execute() {
        return networkDeviceRepository.getSwitchesSummary();
    }
}
