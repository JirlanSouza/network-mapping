package com.networkMapping.installationLocation.application.useCases;

import com.networkMapping.installationLocation.application.dtos.CreateAreaDto;
import com.networkMapping.installationLocation.application.repositories.AreaRepository;
import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.shared.exceptions.AlreadyExistsEntityException;
import com.networkMapping.shared.logger.ApplicationLogger;
import com.networkMapping.shared.logger.ApplicationLoggerFactory;

public class CreateAreaUseCase {
    private final AreaRepository areaRepository;
    private final ApplicationLogger logger;

    public CreateAreaUseCase(AreaRepository areaRepository, ApplicationLoggerFactory loggerFactory) {
        this.areaRepository = areaRepository;
        this.logger = loggerFactory.getLogger(CreateAreaUseCase.class);
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
        logger.info("created new area with id: %s".formatted(area.getId()));

        return area;
    }
}
