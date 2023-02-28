package com.networkMapping.installationLocation.application.useCases;

import com.networkMapping.installationLocation.application.presenters.SubAreaDataPresenter;
import com.networkMapping.installationLocation.application.repositories.SubAreaRepository;

import java.util.List;
import java.util.UUID;

public class GetSubAreasByParentIdUseCase {

    private final SubAreaRepository subAreaRepository;

    public GetSubAreasByParentIdUseCase(SubAreaRepository subAreaRepository) {
        this.subAreaRepository = subAreaRepository;
    }

    public List<SubAreaDataPresenter> execute(UUID parentId) throws RuntimeException {
        return subAreaRepository.findByParentId(parentId);
    }
}
