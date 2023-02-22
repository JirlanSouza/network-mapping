package com.networkMapping.installationLocation.external.restApi.requestDtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateAreaRequestDto(
    @NotNull
    @Size(min = 3, message = "the name must have minimum 3 characters")
    String name
) {
}
