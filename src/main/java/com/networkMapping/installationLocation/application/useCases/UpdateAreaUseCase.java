package com.networkMapping.installationLocation.application.useCases;

import com.networkMapping.installationLocation.application.dtos.UpdateAreaDto;
import com.networkMapping.installationLocation.application.repositories.AreaRepository;
import com.networkMapping.installationLocation.domain.entities.Area;
import com.networkMapping.shared.exceptions.NotFoundEntityException;
import com.networkMapping.shared.logger.ApplicationLogger;
import com.networkMapping.shared.logger.ApplicationLoggerFactory;


public class UpdateAreaUseCase {
    private final ApplicationLogger logger;
    private final AreaRepository areaRepository;

    public UpdateAreaUseCase(AreaRepository areaRepository, ApplicationLoggerFactory loggerFactory) {
        this.areaRepository = areaRepository;
        this.logger = loggerFactory.getLogger(UpdateAreaUseCase.class);
    }

    public Area execute(UpdateAreaDto updateAreaDto) {
        var area = areaRepository.findById(updateAreaDto.id())
            .orElseThrow(() ->
                new NotFoundEntityException("the area with id: %s does not exists".formatted(updateAreaDto.id())
                )
            );

        area.setName(updateAreaDto.name());
        areaRepository.save(area);
        logger.info("updated area with id: %s".formatted(area.getId()));

        return area;
    }
}
