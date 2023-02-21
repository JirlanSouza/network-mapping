package com.networkMapping.installationLocation.repositories.mappers;

import com.networkMapping.installationLocation.models.SubAreaModel;
import com.networkMapping.installationLocation.useCases.presenters.SubAreaDataPresenter;

public class SubAreaModelMapper {
    public static SubAreaDataPresenter toOverviewPresenter(SubAreaModel model) {
        return new SubAreaDataPresenter(model.id, model.name);
    }
}
