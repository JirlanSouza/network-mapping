package com.networkMapping.installationLocation.repositories;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import com.networkMapping.installationLocation.models.AreaModel;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class AreaRepository implements PanacheRepositoryBase<AreaModel, UUID> {
    public boolean exists(UUID id) {
        var result = count("id", id.toString());
        return result > 0;
    }

    public boolean existsByName(String name) {
        var result = count("name", name);
        return result > 0;
    }
}
