package com.networkMapping.networkDevice.external.restApi.requestDtos;

import com.networkMapping.networkDevice.domain.valueObjects.DataSpeedUnit;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateNetworkPortTypeRequestDto(
    @NotNull
    @Size(min = 2)
    String name,

    @Positive
    int speed,
    @NotNull
    DataSpeedUnit speedUnit) {
}
