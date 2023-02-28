package com.networkMapping.networkDevice.external.config;

import com.networkMapping.installationLocation.application.repositories.SubAreaRepository;
import com.networkMapping.networkDevice.application.repositories.NetworkDeviceRepository;
import com.networkMapping.networkDevice.application.useCases.CreateNetworkPortTypeUseCase;
import com.networkMapping.networkDevice.application.useCases.CreateNetworkSwitchUseCase;
import com.networkMapping.networkDevice.application.useCases.GetNetworkSwitchUseCase;
import com.networkMapping.networkDevice.application.useCases.GetNetworkSwitchesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NetworkDeviceConfig {
    @Bean
    public GetNetworkSwitchesUseCase getNetworkSwitchesUseCase(NetworkDeviceRepository repository) {
        return new GetNetworkSwitchesUseCase(repository);
    }

    @Bean
    public GetNetworkSwitchUseCase getNetworkSwitchUseCase(NetworkDeviceRepository repository) {
        return new GetNetworkSwitchUseCase(repository);
    }

    @Bean
    public CreateNetworkSwitchUseCase createNetworkSwitchUseCase(
        NetworkDeviceRepository switchRepository,
        SubAreaRepository subAreaRepository
    ) {
        return new CreateNetworkSwitchUseCase(switchRepository, subAreaRepository);
    }

    @Bean
    public CreateNetworkPortTypeUseCase createNetworkPortTypeUseCase(NetworkDeviceRepository repository) {
        return new CreateNetworkPortTypeUseCase(repository);
    }
}
