package com.networkMapping.installationLocation.useCases;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.dtos.CreateAreaDto;
import com.networkMapping.installationLocation.useCases.repositories.AreaRepository;
import com.networkMapping.shared.exceptions.AlreadyExistsEntityException;
import org.springframework.stereotype.Service;

@Service
public class CreateAreaUseCase {
    private final AreaRepository areaRepository;

    public CreateAreaUseCase(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public Area execute(CreateAreaDto createAreaDto) throws Exception {
        var existsArea = areaRepository.existsByName(createAreaDto.name);

        if (existsArea) {
            throw new AlreadyExistsEntityException(
                String.format("area with name: %s already exists", createAreaDto.name));
        }

        var area = new Area(createAreaDto.name, null);
        areaRepository.save(area);
        return area;
    }
}
