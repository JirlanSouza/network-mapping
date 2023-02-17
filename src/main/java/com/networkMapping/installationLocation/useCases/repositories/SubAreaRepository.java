package com.networkMapping.installationLocation.useCases.repositories;

import com.networkMapping.installationLocation.domain.SubArea;

import java.util.List;
import java.util.UUID;

public interface SubAreaRepository {
    List<SubArea> findByParentId(UUID parentId);

    boolean existsByName(String name);

    void save(SubArea subArea);
}
