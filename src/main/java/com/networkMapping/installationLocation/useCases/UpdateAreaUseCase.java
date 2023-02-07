package com.networkMapping.installationLocation.useCases;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.repositories.AreaRepository;
import com.networkMapping.installationLocation.useCases.dtos.UpdateAreaDto;
import com.networkMapping.shared.exceptions.NotFoundEntityException;

@ApplicationScoped
public class UpdateAreaUseCase {
    private final AreaRepository areaRepository;

    public UpdateAreaUseCase(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Transactional
    public Area execute(UpdateAreaDto updateAreaDto) {
        var existsArea = areaRepository.exists(updateAreaDto.id());

        if (!existsArea) {
            throw new NotFoundEntityException(
                    String.format("the area with id: %s does not exists", updateAreaDto.id()));
        }

        var area = areaRepository.get(updateAreaDto.id());
        area.setName(updateAreaDto.name());
        areaRepository.save(area);

        return area;
    }
}
