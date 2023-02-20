package com.networkMapping.installationLocation.useCases.repositories;

import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.useCases.presenters.SubAreaDataOverviewPresenter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubAreaRepository {
    List<SubAreaDataOverviewPresenter> findByParentId(UUID parentId);

    boolean existsByName(String name);

    void save(SubArea subArea);

    Optional<SubAreaDataOverviewPresenter> getSubAreaData(UUID id);
}
