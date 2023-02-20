package com.networkMapping.installationLocation.useCases.repositories;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.useCases.presenters.AreaDataPresenter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AreaRepository {
    boolean existsByName(String name);

    void save(Area area);

    boolean exists(UUID id);

    Optional<Area> findById(UUID id);

    List<AreaDataPresenter> getAreasData();

    Optional<AreaDataPresenter> getAreaData(UUID id);
}
