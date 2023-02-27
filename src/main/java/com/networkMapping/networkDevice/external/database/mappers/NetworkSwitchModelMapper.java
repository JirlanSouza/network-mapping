package com.networkMapping.networkDevice.external.database.mappers;

import com.networkMapping.networkDevice.application.dtos.GetNetworkSwitchesDto;
import com.networkMapping.networkDevice.external.database.models.NetworkSwitchModel;

public class NetworkSwitchModelMapper {
    public static GetNetworkSwitchesDto networkSwitchesDto(NetworkSwitchModel model) {
        return new GetNetworkSwitchesDto(
            model.getId(),
            model.getIdentificationTag(),
            model.getBrand(),
            model.getModel(),
            model.getPorts().stream().map(NetworkPortModelMapper::postsSummaryDto).toList(),
            model.getInstallationLocal().name
        );
    }
}
