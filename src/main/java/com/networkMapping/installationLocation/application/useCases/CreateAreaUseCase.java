package com.networkMapping.installationLocation.application.useCases;

import com.networkMapping.installationLocation.application.dtos.CreateAreaDto;
import com.networkMapping.installationLocation.application.repositories.AreaRepository;
import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.shared.exceptions.AlreadyExistsEntityException;

public class CreateAreaUseCase {
    private final AreaRepository areaRepository;

    public CreateAreaUseCase(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public Area execute(CreateAreaDto createAreaDto) throws Exception {
        var existsArea = areaRepository.existsByName(createAreaDto.name());

        if (existsArea) {
            throw new AlreadyExistsEntityException(
                String.format("area with name: %s already exists", createAreaDto.name())
            );
        }

        var area = new Area(createAreaDto.name());
        areaRepository.save(area);
        return area;
    }
}
