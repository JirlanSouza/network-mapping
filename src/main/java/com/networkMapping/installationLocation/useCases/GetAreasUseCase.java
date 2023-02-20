package com.networkMapping.installationLocation.useCases;

import com.networkMapping.installationLocation.useCases.presenters.AreaDataPresenter;
import com.networkMapping.installationLocation.useCases.repositories.AreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAreasUseCase {
    final AreaRepository areaRepository;

    public GetAreasUseCase(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<AreaDataPresenter> execute() {
        return areaRepository.getAreasData();
    }
}
