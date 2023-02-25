package com.networkMapping.networkDevice.external.restApi.requestDtos;

import com.networkMapping.networkDevice.application.dtos.CreateNetworkSwitchPortDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record CreateNetworkSwitchPortRequestDto(
    @NotNull
    @Positive
    int startNumber,

    @NotNull
    @Positive
    int endNumber,

    @NotNull
    UUID portTypeId
) {
    public CreateNetworkSwitchPortDto toCreateNetworkSwitchPortDto() {
        return new CreateNetworkSwitchPortDto(startNumber, endNumber, portTypeId);
    }
}
