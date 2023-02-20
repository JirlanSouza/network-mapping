package com.networkMapping.installationLocation.useCases.repositories;

import com.networkMapping.installationLocation.useCases.presenters.AreaDataPresenter;
import com.networkMapping.shared.exceptions.NotFoundEntityException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetAreaUseCase {
    private final AreaRepository areaRepository;

    public GetAreaUseCase(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public AreaDataPresenter execute(UUID id) {
        return areaRepository.getAreaData(id)
            .orElseThrow(() -> new NotFoundEntityException("the area with id: %s does not found".formatted(id)));
    }
}
