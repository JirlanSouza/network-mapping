package com.networkMapping.networkDevice.application.dtos;

import com.networkMapping.networkDevice.domain.valueObjects.NetworkSwitchLayer;

import java.util.List;
import java.util.UUID;

public record GetNetworkSwitchDto(
    UUID id,
    String identificationTag,
    String brand,
    String model,
    List<NetworkPortSummaryDto> ports,
    String installationLocal,
    NetworkSwitchLayer layer
) {
}
