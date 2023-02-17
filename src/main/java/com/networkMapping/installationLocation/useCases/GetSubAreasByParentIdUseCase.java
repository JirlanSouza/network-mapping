package com.networkMapping.installationLocation.useCases;

import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.useCases.repositories.SubAreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetSubAreasByParentIdUseCase {

    private final SubAreaRepository subAreaRepository;

    public GetSubAreasByParentIdUseCase(SubAreaRepository subAreaRepository) {
        this.subAreaRepository = subAreaRepository;
    }

    public List<SubArea> execute(UUID parentId) throws RuntimeException {
        return subAreaRepository.findByParentId(parentId);
    }
}
