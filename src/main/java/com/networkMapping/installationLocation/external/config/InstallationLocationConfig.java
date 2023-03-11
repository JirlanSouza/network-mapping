package com.networkMapping.installationLocation.external.config;

import com.networkMapping.installationLocation.application.repositories.AreaRepository;
import com.networkMapping.installationLocation.application.repositories.SubAreaRepository;
import com.networkMapping.installationLocation.application.useCases.*;
import com.networkMapping.shared.logger.ApplicationLoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstallationLocationConfig {
    @Bean
    public CreateAreaUseCase createAreaUseCase(AreaRepository repository, ApplicationLoggerFactory loggerFactory) {
        return new CreateAreaUseCase(repository, loggerFactory);
    }

    @Bean
    public CreateSubAreaUseCase createSubAreaUseCase(
        SubAreaRepository subAreaRepository,
        AreaRepository areaRepository,
        ApplicationLoggerFactory loggerFactory
    ) {
        return new CreateSubAreaUseCase(subAreaRepository, areaRepository, loggerFactory);
    }

    @Bean
    public UpdateAreaUseCase updateAreaUseCase(AreaRepository repository, ApplicationLoggerFactory loggerFactory) {
        return new UpdateAreaUseCase(repository, loggerFactory);
    }

    @Bean
    public GetAreasUseCase getAreasUseCase(AreaRepository repository) {
        return new GetAreasUseCase(repository);
    }

    @Bean
    public GetAreaUseCase getAreaUseCase(AreaRepository repository) {
        return new GetAreaUseCase(repository);
    }

    @Bean
    public GetSubAreaUseCase getSubAreaUseCase(SubAreaRepository repository) {
        return new GetSubAreaUseCase(repository);
    }

    @Bean
    public GetSubAreasByParentIdUseCase getSubAreasByParentIdUseCase(SubAreaRepository repository) {
        return new GetSubAreasByParentIdUseCase(repository);
    }
}
