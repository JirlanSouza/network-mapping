package com.networkMapping.installationLocation.dtos;

import java.util.UUID;

public record CreateSubAreaUseCaseDto(String name, UUID parentId) {
}
