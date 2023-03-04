package com.networkMapping.installationLocation.application.useCases;

import com.networkMapping.installationLocation.application.dtos.CreateSubAreaDto;
import com.networkMapping.installationLocation.application.repositories.AreaRepository;
import com.networkMapping.installationLocation.application.repositories.SubAreaRepository;
import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.shared.exceptions.AlreadyExistsEntityException;
import com.networkMapping.shared.exceptions.NotFoundEntityException;
import com.networkMapping.shared.logger.ApplicationLogger;
import com.networkMapping.shared.logger.ApplicationLoggerFactory;

public class CreateSubAreaUseCase {
    private final SubAreaRepository subAreaRepository;
    private final AreaRepository areaRepository;
    private final ApplicationLogger logger;

    public CreateSubAreaUseCase(
        SubAreaRepository subAreaRepository,
        AreaRepository areaRepository,
        ApplicationLoggerFactory loggerFactory
    ) {
        this.subAreaRepository = subAreaRepository;
        this.areaRepository = areaRepository;
        this.logger = loggerFactory.getLogger(CreateSubAreaUseCase.class);
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
        logger.info("created new sub area with id: %s".formatted(subArea.getId()));

        return subArea;
    }
}
