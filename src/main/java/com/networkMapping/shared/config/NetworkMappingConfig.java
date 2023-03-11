package com.networkMapping.shared.config;

import com.networkMapping.shared.logger.ApplicationLoggerFactory;
import com.networkMapping.shared.logger.ApplicationLoggerFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NetworkMappingConfig {
    @Bean
    ApplicationLoggerFactory loggerFactory() {
        return new ApplicationLoggerFactoryImpl();
    }
}
