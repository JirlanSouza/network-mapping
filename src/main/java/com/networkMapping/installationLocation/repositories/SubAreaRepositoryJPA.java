package com.networkMapping.installationLocation.repositories;

import com.networkMapping.installationLocation.models.SubAreaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubAreaRepositoryJPA extends CrudRepository<SubAreaModel, UUID> {
    List<SubAreaModel> findByParentId(UUID parentId);

    boolean existsByName(String name);
}
