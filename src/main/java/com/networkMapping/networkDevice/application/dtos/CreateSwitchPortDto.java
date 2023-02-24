package com.networkMapping.networkDevice.application.dtos;

import com.networkMapping.networkDevice.domain.NetworkPortType;

import java.util.UUID;

public record CreateSwitchPortDto(
    int startNumber,
    int endNumber,
    UUID portTypeId
) {
}
