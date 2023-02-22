package com.networkMapping.installationLocation.external.database.repositories;

import com.networkMapping.installationLocation.application.presenters.SubAreaDataPresenter;
import com.networkMapping.installationLocation.application.repositories.SubAreaRepository;
import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.external.database.mappers.SubAreaModelMapper;
import com.networkMapping.installationLocation.external.database.models.SubAreaModel;
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
    public List<SubAreaDataPresenter> findByParentId(UUID parentId) {
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
    public Optional<SubAreaDataPresenter> getSubAreaData(UUID id) {
        return subAreaRepositoryJPA.findById(id).map(SubAreaModelMapper::toOverviewPresenter);
    }
}
