package com.networkMapping.installationLocation.application.useCases;

import com.networkMapping.installationLocation.application.dtos.UpdateAreaDto;
import com.networkMapping.installationLocation.application.repositories.AreaRepository;
import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.shared.exceptions.NotFoundEntityException;


public class UpdateAreaUseCase {
    private final AreaRepository areaRepository;

    public UpdateAreaUseCase(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public Area execute(UpdateAreaDto updateAreaDto) {
        var area = areaRepository.findById(updateAreaDto.id())
            .orElseThrow(() ->
                new NotFoundEntityException("the area with id: %s does not exists".formatted(updateAreaDto.id())
                )
            );

        area.setName(updateAreaDto.name());
        areaRepository.save(area);

        return area;
    }
}
