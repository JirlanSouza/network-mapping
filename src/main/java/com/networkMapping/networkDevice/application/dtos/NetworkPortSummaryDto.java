package com.networkMapping.networkDevice.application.dtos;

import com.networkMapping.networkDevice.domain.valueObjects.DataSpeedUnit;

import java.util.UUID;

public record NetworkPortSummaryDto(
    UUID id,
    int number,
    String type,
    int speed,
    DataSpeedUnit speedUnit
) {
}
