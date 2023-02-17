package com.networkMapping.installationLocation.useCases;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.repositories.AreaRepositoryJPA;
import com.networkMapping.installationLocation.useCases.dtos.UpdateAreaDto;
import com.networkMapping.shared.exceptions.NotFoundEntityException;
import org.springframework.stereotype.Service;

@Service
public class UpdateAreaUseCase {
    private final AreaRepositoryJPA areaRepository;

    public UpdateAreaUseCase(AreaRepositoryJPA areaRepository) {
        this.areaRepository = areaRepository;
    }

    public Area execute(UpdateAreaDto updateAreaDto) {
        var area = areaRepository.findById(updateAreaDto.id())
            .orElseThrow( () ->
                new NotFoundEntityException(String.format("the area with id: %s does not exists", updateAreaDto.id())
            ));


        area.name = updateAreaDto.name();
        areaRepository.save(area);

        return new Area(area.id, area.name, null);
    }
}
