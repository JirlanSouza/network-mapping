package com.networkMapping.networkDevice.application.dtos;

import com.networkMapping.networkDevice.domain.valueObjects.NetworkSwitchLayer;

import java.util.List;
import java.util.UUID;

public record CreateNetworkSwitchDto(
    String identificationTag,
    String brand,
    String model,
    List<CreateNetworkSwitchPortDto> ports,
    UUID installationLocalId,
    NetworkSwitchLayer layer
) {
}
