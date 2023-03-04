package com.networkMapping.installationLocation.application.repositories;

import com.networkMapping.installationLocation.domain.entities.Area;
import com.networkMapping.installationLocation.application.presenters.AreaDataPresenter;

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
