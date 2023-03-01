package com.networkMapping.networkDevice.external.restApi.requestDtos;

import com.networkMapping.networkDevice.application.dtos.CreateNetworkSwitchDto;
import com.networkMapping.networkDevice.domain.valueObjects.NetworkSwitchLayer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public record CreateNetworkSwitchRequestDto(
    @NotNull
    @Size(min = 3)
    String identificationTag,

    @NotNull
    @Size(min = 2)
    String brand,

    @NotNull
    @Size(min = 3)
    String model,
    List<CreateNetworkSwitchPortRequestDto> ports,

    @NotNull
    UUID installationLocalId,

    @NotNull
    NetworkSwitchLayer layer
) {
    public CreateNetworkSwitchDto toCreateNetworkSwitchDto() {

        return new CreateNetworkSwitchDto(
            identificationTag,
            brand,
            model,
            ports.stream().map(CreateNetworkSwitchPortRequestDto::toCreateNetworkSwitchPortDto).toList(),
            installationLocalId,
            layer
        );
    }
}
