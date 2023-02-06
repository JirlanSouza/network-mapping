package com.networkMapping.installationLocation.useCases;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.dtos.CreateSubAreaUseCaseDto;
import com.networkMapping.installationLocation.models.SubAreaModel;
import com.networkMapping.installationLocation.repositories.AreaRepository;
import com.networkMapping.installationLocation.repositories.SubAreasRepository;
import com.networkMapping.shared.exceptions.AlreadyExistsEntityException;
import com.networkMapping.shared.exceptions.NotFoundEntityException;

@ApplicationScoped
public class CreateSubAreaUseCase {
    private SubAreasRepository subAreasRepository;
    private AreaRepository areaRepository;

    public CreateSubAreaUseCase(SubAreasRepository subAreasRepository, AreaRepository areaRepository) {
        this.subAreasRepository = subAreasRepository;
        this.areaRepository = areaRepository;
    }

    @Transactional
    public SubArea execute(CreateSubAreaUseCaseDto createSubAreaDto) {
        var existsArea = areaRepository.exists(createSubAreaDto.parentId());

        if (!existsArea) {
            throw new NotFoundEntityException(
                    String.format("the sub area parent with id: %s does not exists", createSubAreaDto.parentId()));
        }

        var existsSubArea = subAreasRepository.existsByName(createSubAreaDto.name());

        if (existsSubArea) {
            throw new AlreadyExistsEntityException(
                    String.format("the sub area with name: %s already exists", createSubAreaDto.name()));
        }

        var subArea = new SubArea(createSubAreaDto.name(), createSubAreaDto.parentId());
        var subAreaModel = new SubAreaModel(subArea);
        subAreasRepository.persist(subAreaModel);

        return subArea;
    }
}
