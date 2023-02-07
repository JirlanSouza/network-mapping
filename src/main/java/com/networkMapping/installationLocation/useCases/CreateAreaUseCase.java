package com.networkMapping.installationLocation.useCases;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.dtos.CreateAreaDto;
import com.networkMapping.installationLocation.repositories.AreaRepository;
import com.networkMapping.shared.exceptions.AlreadyExistsEntityException;

@ApplicationScoped
public class CreateAreaUseCase {
    private AreaRepository areaRepository;

    public CreateAreaUseCase(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Transactional
    public Area execute(CreateAreaDto createAreaDto) throws Exception {
        var existsArea = areaRepository.existsByName(createAreaDto.name);

        if (existsArea) {
            throw new AlreadyExistsEntityException(
                    String.format("area with name: %s alredy exists", createAreaDto.name));
        }

        var area = new Area(createAreaDto.name, null);
        areaRepository.save(area);
        return area;
    }
}
