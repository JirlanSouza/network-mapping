package com.networkMapping.networkDevice.external.database.mappers;

import com.networkMapping.networkDevice.application.dtos.GetNetworkSwitchDto;
import com.networkMapping.networkDevice.external.database.models.NetworkSwitchModel;

public class NetworkSwitchModelMapper {
    public static GetNetworkSwitchDto networkSwitchesDto(NetworkSwitchModel model) {
        return new GetNetworkSwitchDto(
            model.getId(),
            model.getIdentificationTag(),
            model.getBrand(),
            model.getModel(),
            model.getPorts().stream().map(NetworkPortModelMapper::postsSummaryDto).toList(),
            model.getInstallationLocal().name,
            model.getLayer()
        );
    }
}
