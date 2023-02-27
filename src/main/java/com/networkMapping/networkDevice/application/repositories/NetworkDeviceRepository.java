package com.networkMapping.networkDevice.application.repositories;

import com.networkMapping.networkDevice.application.dtos.GetNetworkSwitchesDto;
import com.networkMapping.networkDevice.domain.NetworkPortType;
import com.networkMapping.networkDevice.domain.NetworkSwitch;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NetworkDeviceRepository {
    boolean existsPortType(NetworkPortType portType);

    void savePortType(NetworkPortType portType);

    Optional<NetworkPortType> getPortType(UUID id);

    void saveSwitch(NetworkSwitch networkSwitch);

    List<GetNetworkSwitchesDto> getSwitchesSummary();
}
