package com.networkMapping.installationLocation.repositories;

import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.models.SubAreaModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface SubAreaRepositoryJPA extends CrudRepository<SubAreaModel, UUID> {
    List<SubAreaModel> findByParentId(UUID parentId);

    long countByName(String name);
}
