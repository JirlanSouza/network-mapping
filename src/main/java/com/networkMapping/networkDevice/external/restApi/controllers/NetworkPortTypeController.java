package com.networkMapping.networkDevice.external.restApi.controllers;

import com.networkMapping.networkDevice.application.useCases.CreateNetworkPortTypeUseCase;
import com.networkMapping.networkDevice.domain.NetworkPortType;
import com.networkMapping.networkDevice.external.restApi.requestDtos.CreateNetworkPortTypeRequestDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "networkPortType")
@RequestMapping("network-port-types")
public class NetworkPortTypeController {
    private final CreateNetworkPortTypeUseCase createNetworkPortTypeUseCase;

    public NetworkPortTypeController(CreateNetworkPortTypeUseCase createNetworkPortTypeUseCase) {
        this.createNetworkPortTypeUseCase = createNetworkPortTypeUseCase;
    }

    @PostMapping
    public NetworkPortType createNetworkPortType(@RequestBody @Valid CreateNetworkPortTypeRequestDto requestDto) {
        return createNetworkPortTypeUseCase.execute(new NetworkPortType(
                requestDto.name(),
                requestDto.speed(),
                requestDto.speedUnit()
            )
        );
    }
}
