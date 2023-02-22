package com.networkMapping.installationLocation.external.database.mappers;

import com.networkMapping.installationLocation.external.database.models.AreaModel;
import com.networkMapping.installationLocation.application.presenters.AreaDataPresenter;

public class AreaModelMapper {
    static public AreaDataPresenter toAreaDataPresenter(AreaModel model) {
        return new AreaDataPresenter(
            model.id,
            model.name,
            model.subAreas.stream().map(SubAreaModelMapper::toOverviewPresenter).toList()
        );
    }
}
