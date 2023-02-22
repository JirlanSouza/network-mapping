package com.networkMapping.installationLocation.application.presenters;

import java.util.List;
import java.util.UUID;

public record AreaDataPresenter(UUID id, String name, List<SubAreaDataPresenter> subAreas) {
}
