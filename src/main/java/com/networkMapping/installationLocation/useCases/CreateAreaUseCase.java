package com.networkMapping.installationLocation.useCases;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.dtos.CreateAreaDto;
import com.networkMapping.installationLocation.ormEntities.AreaOrmEntity;
import com.networkMapping.installationLocation.repositories.AreaRepository;

@ApplicationScoped
public class CreateAreaUseCase {
    private AreaRepository areaRepository;

    public CreateAreaUseCase(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Transactional
    public Area execute(CreateAreaDto createAreaDto) throws Exception {
        var existArea = areaRepository.existsByName(createAreaDto.getName());

        if (existArea) {
            throw new Exception();
        }

        var area = new Area(createAreaDto.getName(), null);
        var areaOrmEntity = new AreaOrmEntity(area);
        areaRepository.persist(areaOrmEntity);
        return area;
    }
}
