package com.networkMapping.installationLocation.useCases.repositories;

import com.networkMapping.installationLocation.domain.Area;

import java.util.Optional;
import java.util.UUID;

public interface AreaRepository {
    boolean existsByName(String name);

    void save(Area area);

    boolean exists(UUID id);

    Optional<Area> findById(UUID id);
}
