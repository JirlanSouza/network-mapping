package com.networkMapping.installationLocation.external.restApi.requestDtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateSubAreaRequestDto(
    @NotNull
    @Size(min = 3)
    String name
) {
}
