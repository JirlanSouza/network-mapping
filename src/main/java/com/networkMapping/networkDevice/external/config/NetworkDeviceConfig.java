package com.networkMapping.networkDevice.external.config;

import com.networkMapping.networkDevice.application.repositories.NetworkDeviceRepository;
import com.networkMapping.networkDevice.application.useCases.GetNetworkSwitchesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NetworkDeviceConfig {
    @Bean
    public GetNetworkSwitchesUseCase getNetworkSwitchesUseCase(NetworkDeviceRepository repository) {
        return new GetNetworkSwitchesUseCase(repository);
    }
}
