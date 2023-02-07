package com.networkMapping.installationLocation.repositories;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.models.AreaModel;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class AreaRepository implements PanacheRepositoryBase<AreaModel, String> {
    public boolean exists(UUID id) {
        var result = count("id", id.toString());
        return result > 0;
    }

    public boolean existsByName(String name) {
        var result = count("name", name);
        return result > 0;
    }

    public Area get(UUID id) {
        var areaModel = findById(id.toString());
        return toArea(areaModel);
    }

    public void save(Area area) {
        var areaModel = new AreaModel();
        areaModel.id = area.getId().toString();
        areaModel.name = area.getName();
        persist(areaModel);
    }

    private Area toArea(AreaModel areaModel) {
        return new Area(UUID.fromString(areaModel.id), areaModel.name, null);
    }
}
