package com.networkMapping.installationLocation.repositories.mappers;

import com.networkMapping.installationLocation.models.SubAreaModel;
import com.networkMapping.installationLocation.useCases.presenters.SubAreaDataOverviewPresenter;

public class SubAreaModelMapper {
    public static SubAreaDataOverviewPresenter toOverviewPresenter(SubAreaModel model) {
        return new SubAreaDataOverviewPresenter(model.id, model.name);
    }
}
