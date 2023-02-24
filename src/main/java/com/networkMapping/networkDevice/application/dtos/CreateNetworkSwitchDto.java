package com.networkMapping.networkDevice.application.dtos;

import java.util.List;
import java.util.UUID;

public record CreateNetworkSwitchDto(
    String identificationTag,
    String brand,
    String model,
    List<CreateSwitchPortDto> ports,
    UUID installationLocalId
) {
}
