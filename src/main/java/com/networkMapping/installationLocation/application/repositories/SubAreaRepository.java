package com.networkMapping.installationLocation.application.repositories;

import com.networkMapping.installationLocation.application.presenters.SubAreaDataPresenter;
import com.networkMapping.installationLocation.domain.entities.SubArea;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubAreaRepository {
    List<SubAreaDataPresenter> findByParentId(UUID parentId);

    boolean existsByName(String name);

    void save(SubArea subArea);

    Optional<SubAreaDataPresenter> getSubAreaData(UUID id);

    boolean exists(UUID id);
}
