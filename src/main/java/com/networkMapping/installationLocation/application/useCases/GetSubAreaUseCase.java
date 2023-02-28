package com.networkMapping.installationLocation.application.useCases;

import com.networkMapping.installationLocation.application.presenters.SubAreaDataPresenter;
import com.networkMapping.installationLocation.application.repositories.SubAreaRepository;
import com.networkMapping.shared.exceptions.NotFoundEntityException;

import java.util.UUID;

public class GetSubAreaUseCase {
    private final SubAreaRepository subAreaRepository;

    public GetSubAreaUseCase(SubAreaRepository subAreaRepository) {
        this.subAreaRepository = subAreaRepository;
    }

    public SubAreaDataPresenter execute(UUID id) {
        return subAreaRepository.getSubAreaData(id)
            .orElseThrow(() -> new NotFoundEntityException(
                    "the sub area with id: %s does not found".formatted(id)
                )
            );
    }
}
