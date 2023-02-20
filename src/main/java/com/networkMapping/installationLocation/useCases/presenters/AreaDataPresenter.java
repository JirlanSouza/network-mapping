package com.networkMapping.installationLocation.useCases.presenters;

import java.util.List;
import java.util.UUID;

public record AreaDataPresenter(UUID id, String name, List<SubAreaDataOverviewPresenter> subAreas) {
}
