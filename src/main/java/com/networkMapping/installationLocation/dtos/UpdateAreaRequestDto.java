package com.networkMapping.installationLocation.dtos;

import jakarta.validation.constraints.Size;

public class UpdateAreaRequestDto {
    @Size(min = 3, message = "the name must have minimum 3 characters")
    public String name;
}
