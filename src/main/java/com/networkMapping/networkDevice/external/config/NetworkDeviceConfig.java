package com.networkMapping.networkDevice.external.config;

import com.networkMapping.installationLocation.application.repositories.SubAreaRepository;
import com.networkMapping.networkDevice.application.repositories.NetworkDeviceRepository;
import com.networkMapping.networkDevice.application.useCases.CreateNetworkPortTypeUseCase;
import com.networkMapping.networkDevice.application.useCases.CreateNetworkSwitchUseCase;
import com.networkMapping.networkDevice.application.useCases.GetNetworkSwitchUseCase;
import com.networkMapping.networkDevice.application.useCases.GetNetworkSwitchesUseCase;
import com.networkMapping.shared.logger.ApplicationLoggerFactory;
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
        SubAreaRepository subAreaRepository,
        ApplicationLoggerFactory loggerFactory
    ) {
        return new CreateNetworkSwitchUseCase(switchRepository, subAreaRepository, loggerFactory);
    }

    @Bean
    public CreateNetworkPortTypeUseCase createNetworkPortTypeUseCase(
        NetworkDeviceRepository repository,
        ApplicationLoggerFactory loggerFactory
    ) {
        return new CreateNetworkPortTypeUseCase(repository, loggerFactory);
    }
}
