package com.networkMapping.installationLocation.application.useCases;

import com.networkMapping.installationLocation.application.presenters.AreaDataPresenter;
import com.networkMapping.installationLocation.application.repositories.AreaRepository;
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
