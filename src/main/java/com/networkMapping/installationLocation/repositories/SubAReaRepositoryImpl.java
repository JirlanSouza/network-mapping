package com.networkMapping.installationLocation.repositories;

import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.models.SubAreaModel;
import com.networkMapping.installationLocation.repositories.mappers.SubAreaModelMapper;
import com.networkMapping.installationLocation.useCases.presenters.SubAreaDataOverviewPresenter;
import com.networkMapping.installationLocation.useCases.repositories.SubAreaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SubAReaRepositoryImpl implements SubAreaRepository {

    private final SubAreaRepositoryJPA subAreaRepositoryJPA;

    public SubAReaRepositoryImpl(SubAreaRepositoryJPA subAreaRepositoryJPA) {
        this.subAreaRepositoryJPA = subAreaRepositoryJPA;
    }

    @Override
    public List<SubAreaDataOverviewPresenter> findByParentId(UUID parentId) {
        return subAreaRepositoryJPA.findByParentId(parentId)
            .stream()
            .map(SubAreaModelMapper::toOverviewPresenter)
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

    @Override
    public Optional<SubAreaDataOverviewPresenter> getSubAreaData(UUID id) {
        return subAreaRepositoryJPA.findById(id).map(SubAreaModelMapper::toOverviewPresenter);
    }
}
