package com.networkMapping.installationLocation.application.useCases;

import com.networkMapping.installationLocation.application.dtos.CreateSubAreaDto;
import com.networkMapping.installationLocation.application.repositories.AreaRepository;
import com.networkMapping.installationLocation.application.repositories.SubAreaRepository;
import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.shared.exceptions.AlreadyExistsEntityException;
import com.networkMapping.shared.exceptions.NotFoundEntityException;

public class CreateSubAreaUseCase {
    private final SubAreaRepository subAreaRepository;
    private final AreaRepository areaRepository;

    public CreateSubAreaUseCase(SubAreaRepository subAreaRepository, AreaRepository areaRepository) {
        this.subAreaRepository = subAreaRepository;
        this.areaRepository = areaRepository;
    }


    public SubArea execute(CreateSubAreaDto createSubAreaDto) {
        var existsArea = areaRepository.exists(createSubAreaDto.parentId());

        if (!existsArea) {
            throw new NotFoundEntityException(
                String.format("the sub area parent with id: %s does not exists", createSubAreaDto.parentId())
            );
        }

        var existsSubArea = subAreaRepository.existsByName(createSubAreaDto.name());

        if (existsSubArea) {
            throw new AlreadyExistsEntityException(
                String.format("the sub area with name: %s already exists", createSubAreaDto.name())
            );
        }

        var subArea = new SubArea(createSubAreaDto.name(), createSubAreaDto.parentId());
        subAreaRepository.save(subArea);

        return subArea;
    }
}
