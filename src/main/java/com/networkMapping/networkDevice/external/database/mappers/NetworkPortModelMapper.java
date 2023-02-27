package com.networkMapping.networkDevice.external.database.mappers;

import com.networkMapping.networkDevice.application.dtos.NetworkPortSummaryDto;
import com.networkMapping.networkDevice.external.database.models.NetworkPortModel;

public class NetworkPortModelMapper {
    static NetworkPortSummaryDto postsSummaryDto(NetworkPortModel model) {
        var type = model.getPortType();
        return new NetworkPortSummaryDto(
            model.getId(),
            model.getNumber(),
            type.getName(),
            type.getSpeed(),
            type.getSpeedUnit()
        );
    }
}
