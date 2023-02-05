package com.networkMapping.installationLocation.useCases;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.repositories.SubAreasRepository;

@ApplicationScoped
public class GetSubAreasByParentIdUseCase {
    @Inject
    SubAreasRepository subAreasRepository;

    public List<SubArea> execute(UUID parentId) throws RuntimeException {
        return subAreasRepository.findByParentId(parentId);
    }
}
