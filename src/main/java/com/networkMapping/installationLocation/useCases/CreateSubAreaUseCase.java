package com.networkMapping.installationLocation.useCases;

import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.dtos.CreateSubAreaUseCaseDto;
import com.networkMapping.installationLocation.useCases.repositories.AreaRepository;
import com.networkMapping.installationLocation.useCases.repositories.SubAreaRepository;
import com.networkMapping.shared.exceptions.AlreadyExistsEntityException;
import com.networkMapping.shared.exceptions.NotFoundEntityException;
import org.springframework.stereotype.Service;

@Service
public class CreateSubAreaUseCase {
    private final SubAreaRepository subAreaRepository;
    private final AreaRepository areaRepository;

    public CreateSubAreaUseCase(SubAreaRepository subAreaRepository, AreaRepository areaRepository) {
        this.subAreaRepository = subAreaRepository;
        this.areaRepository = areaRepository;
    }


    public SubArea execute(CreateSubAreaUseCaseDto createSubAreaDto) {
        var existsArea = areaRepository.exists(createSubAreaDto.parentId());

        if (!existsArea) {
            throw new NotFoundEntityException(
                String.format("the sub area parent with id: %s does not exists", createSubAreaDto.parentId()));
        }

        var existsSubArea = subAreaRepository.existsByName(createSubAreaDto.name());

        if (existsSubArea) {
            throw new AlreadyExistsEntityException(
                String.format("the sub area with name: %s already exists", createSubAreaDto.name()));
        }

        var subArea = new SubArea(createSubAreaDto.name(), createSubAreaDto.parentId());
        subAreaRepository.save(subArea);

        return subArea;
    }
}
