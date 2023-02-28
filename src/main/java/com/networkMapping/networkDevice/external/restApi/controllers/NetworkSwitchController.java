package com.networkMapping.networkDevice.external.restApi.controllers;

import com.networkMapping.networkDevice.application.dtos.GetNetworkSwitchDto;
import com.networkMapping.networkDevice.application.useCases.CreateNetworkSwitchUseCase;
import com.networkMapping.networkDevice.application.useCases.GetNetworkSwitchUseCase;
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
    private final GetNetworkSwitchUseCase getNetworkSwitchUseCase;
    private final CreateNetworkSwitchUseCase createNetworkSwitchUseCase;

    public NetworkSwitchController(
        GetNetworkSwitchesUseCase getNetworkSwitchesUseCase,
        GetNetworkSwitchUseCase getNetworkSwitchUseCase, CreateNetworkSwitchUseCase createNetworkSwitchUseCase
    ) {
        this.getNetworkSwitchesUseCase = getNetworkSwitchesUseCase;
        this.getNetworkSwitchUseCase = getNetworkSwitchUseCase;
        this.createNetworkSwitchUseCase = createNetworkSwitchUseCase;
    }

    @GetMapping
    public List<GetNetworkSwitchDto> getNetworkSwitches() {
        return getNetworkSwitchesUseCase.execute();
    }

    @GetMapping("/{id}")
    public GetNetworkSwitchDto getNetworkSwitch(@PathVariable UUID id) {
        return getNetworkSwitchUseCase.execute(id);
    }

    @PostMapping
    public UUID createNetworkSwitch(@RequestBody @Valid CreateNetworkSwitchRequestDto requestDto) {
        return createNetworkSwitchUseCase.execute(requestDto.toCreateNetworkSwitchDto());
    }
}
