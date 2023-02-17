package com.networkMapping.installationLocation.dtos;

import jakarta.validation.constraints.Size;

public class CreateSubAreaDto {
    @Size(min = 3)
    public String name;
}
