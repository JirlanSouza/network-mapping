package com.networkMapping.installationLocation.repositories;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.models.AreaModel;
import com.networkMapping.installationLocation.useCases.repositories.AreaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AreaRepositoryImpl implements AreaRepository {
    private final AreaRepositoryJPA areaRepositoryJPA;

    public AreaRepositoryImpl(AreaRepositoryJPA areaRepositoryJPA) {
        this.areaRepositoryJPA = areaRepositoryJPA;
    }

    @Override
    public boolean existsByName(String name) {
        return areaRepositoryJPA.countByName(name) > 0;
    }

    @Override
    public void save(Area area) {
        areaRepositoryJPA.save(new AreaModel(area));
    }

    @Override
    public boolean exists(UUID id) {
        return areaRepositoryJPA.countById(id) > 0;
    }
}
