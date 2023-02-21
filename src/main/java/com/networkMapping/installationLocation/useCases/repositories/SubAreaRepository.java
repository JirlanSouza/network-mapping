package com.networkMapping.installationLocation.useCases.repositories;

import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.useCases.presenters.SubAreaDataPresenter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubAreaRepository {
    List<SubAreaDataPresenter> findByParentId(UUID parentId);

    boolean existsByName(String name);

    void save(SubArea subArea);

    Optional<SubAreaDataPresenter> getSubAreaData(UUID id);
}
