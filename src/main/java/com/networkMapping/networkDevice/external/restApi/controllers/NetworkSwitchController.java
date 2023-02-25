package com.networkMapping.networkDevice.external.restApi.controllers;

import com.networkMapping.networkDevice.application.useCases.CreateNetworkSwitchUseCase;
import com.networkMapping.networkDevice.external.restApi.requestDtos.CreateNetworkSwitchRequestDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController(value = "network_switch")
@RequestMapping("/network-switches")
public class NetworkSwitchController {
    private final CreateNetworkSwitchUseCase createNetworkSwitchUseCase;

    public NetworkSwitchController(CreateNetworkSwitchUseCase createNetworkSwitchUseCase) {
        this.createNetworkSwitchUseCase = createNetworkSwitchUseCase;
    }

    @PostMapping
    public UUID createNetworkSwitch(@RequestBody @Valid CreateNetworkSwitchRequestDto requestDto) {
        return createNetworkSwitchUseCase.execute(requestDto.toCreateNetworkSwitchDto());
    }
}
