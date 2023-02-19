package com.networkMapping.installationLocation.repositories;

import com.networkMapping.installationLocation.models.AreaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AreaRepositoryJPA extends CrudRepository<AreaModel, UUID> {
    boolean existsByName(String name);
    boolean existsById(UUID id);
}
