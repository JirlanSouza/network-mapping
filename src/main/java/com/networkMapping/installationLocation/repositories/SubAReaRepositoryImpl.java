package com.networkMapping.installationLocation.repositories;

import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.models.SubAreaModel;
import com.networkMapping.installationLocation.useCases.repositories.SubAreaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SubAReaRepositoryImpl implements SubAreaRepository {

    private final SubAreaRepositoryJPA subAreaRepositoryJPA;

    public SubAReaRepositoryImpl(SubAreaRepositoryJPA subAreaRepositoryJPA) {
        this.subAreaRepositoryJPA = subAreaRepositoryJPA;
    }

    @Override
    public List<SubArea> findByParentId(UUID parentId) {
        return subAreaRepositoryJPA.findByParentId(parentId)
            .stream()
            .map(SubAreaModel::toSubArea)
            .toList();
    }

    @Override
    public boolean existsByName(String name) {
        return subAreaRepositoryJPA.existsByName(name);
    }

    @Override
    public void save(SubArea subArea) {
        subAreaRepositoryJPA.save(new SubAreaModel(subArea));
    }
}
