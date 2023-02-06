package com.networkMapping.installationLocation.repositories;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.models.SubAreaModel;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class SubAreasRepository implements PanacheRepositoryBase<SubAreaModel, UUID> {
    public List<SubArea> findByParentId(UUID parentId) {
        var subAreasModels = find("parent_id", parentId.toString());
        return subAreasModels.stream().map(this::toSubArea).toList();
    }

    public boolean existsByName(String name) {
        var subAreasCount = count("name", name);
        return subAreasCount > 0;
    }

    private SubArea toSubArea(SubAreaModel model) {
        return new SubArea(UUID.fromString(model.id), model.name, UUID.fromString(model.parentId));
    }
}
