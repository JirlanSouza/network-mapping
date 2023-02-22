package com.networkMapping.installationLocation.application.dtos;

import java.util.UUID;

public record CreateSubAreaDto(String name, UUID parentId) {
}
