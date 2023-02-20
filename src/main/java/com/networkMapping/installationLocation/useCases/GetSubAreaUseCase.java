package com.networkMapping.installationLocation.useCases;

import com.networkMapping.installationLocation.useCases.presenters.SubAreaDataOverviewPresenter;
import com.networkMapping.installationLocation.useCases.repositories.SubAreaRepository;
import com.networkMapping.shared.exceptions.NotFoundEntityException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetSubAreaUseCase {
    private final SubAreaRepository subAreaRepository;

    public GetSubAreaUseCase(SubAreaRepository subAreaRepository) {
        this.subAreaRepository = subAreaRepository;
    }

    public SubAreaDataOverviewPresenter execute(UUID id) {
        return subAreaRepository.getSubAreaData(id)
            .orElseThrow(() ->
                new NotFoundEntityException("the sub area with id: %s does not found".formatted(id)
                )
            );
    }
}
