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
        var subAreasModels = find("parent_id", parentId);
        return subAreasModels.stream().map(this::toSubArea).toList();
    }

    private SubArea toSubArea(SubAreaModel model) {
        return new SubArea(model.id, model.name, model.parentId);
    }
}
