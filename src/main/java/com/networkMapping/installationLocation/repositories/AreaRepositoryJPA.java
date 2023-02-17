package com.networkMapping.installationLocation.repositories;

import com.networkMapping.installationLocation.models.AreaModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AreaRepositoryJPA extends CrudRepository<AreaModel, UUID> {
    long countByName(String name);
    long countById(UUID id);
}
