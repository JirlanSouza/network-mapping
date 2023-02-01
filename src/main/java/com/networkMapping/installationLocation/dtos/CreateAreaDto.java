package com.networkMapping.installationLocation.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateAreaDto {
    @NotBlank
    @Min(value = 3)
    private String name;

    public CreateAreaDto() {
    }

    public CreateAreaDto(@NotBlank @Size(min = 3) String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
