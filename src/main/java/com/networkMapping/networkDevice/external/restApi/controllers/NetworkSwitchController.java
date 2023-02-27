package com.networkMapping.networkDevice.external.restApi.controllers;

import com.networkMapping.networkDevice.application.dtos.GetNetworkSwitchesDto;
import com.networkMapping.networkDevice.application.useCases.CreateNetworkSwitchUseCase;
import com.networkMapping.networkDevice.application.useCases.GetNetworkSwitchesUseCase;
import com.networkMapping.networkDevice.external.restApi.requestDtos.CreateNetworkSwitchRequestDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController(value = "network_switch")
@RequestMapping("/network-switches")
public class NetworkSwitchController {
    private final GetNetworkSwitchesUseCase getNetworkSwitchesUseCase;
    private final CreateNetworkSwitchUseCase createNetworkSwitchUseCase;

    public NetworkSwitchController(
        GetNetworkSwitchesUseCase getNetworkSwitchesUseCase,
        CreateNetworkSwitchUseCase createNetworkSwitchUseCase
    ) {
        this.getNetworkSwitchesUseCase = getNetworkSwitchesUseCase;
        this.createNetworkSwitchUseCase = createNetworkSwitchUseCase;
    }

    @GetMapping
    public List<GetNetworkSwitchesDto> getNetworkSwitches() {
        return getNetworkSwitchesUseCase.execute();
    }

    @PostMapping
    public UUID createNetworkSwitch(@RequestBody @Valid CreateNetworkSwitchRequestDto requestDto) {
        return createNetworkSwitchUseCase.execute(requestDto.toCreateNetworkSwitchDto());
    }
}
