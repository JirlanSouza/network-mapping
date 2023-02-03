package com.networkMapping.installationLocation.useCases;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.repositories.AreaRepository;

@ApplicationScoped
public class GetAreasUseCase {
    final AreaRepository areaRepository;

    public GetAreasUseCase(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<Area> execute() {
        var areas = areaRepository.findAll().stream().map(areaOrmEntity -> areaOrmEntity.toArea()).toList();
        return areas;
    }
}
