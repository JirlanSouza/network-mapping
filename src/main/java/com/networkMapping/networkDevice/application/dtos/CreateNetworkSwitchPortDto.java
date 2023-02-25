package com.networkMapping.networkDevice.application.dtos;

import java.util.UUID;

public record CreateNetworkSwitchPortDto(
    int startNumber,
    int endNumber,
    UUID portTypeId
) {
}
