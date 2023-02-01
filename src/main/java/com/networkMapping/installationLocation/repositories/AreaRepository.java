package com.networkMapping.installationLocation.repositories;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import com.networkMapping.installationLocation.ormEntities.AreaOrmEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class AreaRepository implements PanacheRepositoryBase<AreaOrmEntity, UUID> {
    public boolean existsByName(String name) {
        var result = count("name", name);
        return result > 0;
    }
}
