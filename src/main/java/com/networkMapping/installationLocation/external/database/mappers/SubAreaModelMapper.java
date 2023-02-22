package com.networkMapping.installationLocation.external.database.mappers;

import com.networkMapping.installationLocation.external.database.models.SubAreaModel;
import com.networkMapping.installationLocation.application.presenters.SubAreaDataPresenter;

public class SubAreaModelMapper {
    public static SubAreaDataPresenter toOverviewPresenter(SubAreaModel model) {
        return new SubAreaDataPresenter(model.id, model.name);
    }
}
