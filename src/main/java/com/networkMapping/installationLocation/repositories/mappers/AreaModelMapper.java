package com.networkMapping.installationLocation.repositories.mappers;

import com.networkMapping.installationLocation.models.AreaModel;
import com.networkMapping.installationLocation.useCases.presenters.AreaDataPresenter;

public class AreaModelMapper {
    static public AreaDataPresenter toAreaDataPresenter(AreaModel model) {
        return new AreaDataPresenter(
            model.id,
            model.name,
            model.subAreas.stream().map(SubAreaModelMapper::toOverviewPresenter).toList()
        );
    }
}
