package com.networkMapping.installationLocation.useCases;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.models.AreaModel;
import com.networkMapping.installationLocation.repositories.AreaRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class GetAreasUseCase {
    final AreaRepositoryJPA areaRepository;

    public GetAreasUseCase(AreaRepositoryJPA areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<Area> execute() {
        return StreamSupport.stream(areaRepository.findAll().spliterator(), false)
            .map(AreaModel::toArea)
            .toList();
    }
}
