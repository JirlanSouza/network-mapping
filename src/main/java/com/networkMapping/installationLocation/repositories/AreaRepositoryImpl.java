package com.networkMapping.installationLocation.repositories;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.models.AreaModel;
import com.networkMapping.installationLocation.repositories.mappers.AreaModelMapper;
import com.networkMapping.installationLocation.useCases.presenters.AreaDataPresenter;
import com.networkMapping.installationLocation.useCases.repositories.AreaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AreaRepositoryImpl implements AreaRepository {
    private final AreaRepositoryJPA areaRepositoryJPA;

    public AreaRepositoryImpl(AreaRepositoryJPA areaRepositoryJPA) {
        this.areaRepositoryJPA = areaRepositoryJPA;
    }

    @Override
    public boolean existsByName(String name) {
        return areaRepositoryJPA.existsByName(name);
    }

    @Override
    public void save(Area area) {
        areaRepositoryJPA.save(new AreaModel(area));
    }

    @Override
    public boolean exists(UUID id) {
        return areaRepositoryJPA.existsById(id);
    }

    @Override
    public Optional<Area> findById(UUID id) {
        return areaRepositoryJPA.findById(id).map(AreaModel::toArea);
    }

    @Override
    public List<AreaDataPresenter> getAreasData() {

        return areaRepositoryJPA.findAllData()
            .stream().map(AreaModelMapper::toAreaDataPresenter)
            .toList();
    }

    @Override
    public Optional<AreaDataPresenter> getAreaData(UUID id) {
        return areaRepositoryJPA.findById(id).map(AreaModelMapper::toAreaDataPresenter);
    }
}
