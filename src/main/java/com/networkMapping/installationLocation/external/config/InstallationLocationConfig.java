package com.networkMapping.installationLocation.external.config;

import com.networkMapping.installationLocation.application.repositories.AreaRepository;
import com.networkMapping.installationLocation.application.repositories.SubAreaRepository;
import com.networkMapping.installationLocation.application.useCases.*;
import com.networkMapping.shared.logger.ApplicationLoggerFactory;
import com.networkMapping.shared.logger.ApplicationLoggerFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstallationLocationConfig {

    @Bean
    ApplicationLoggerFactory loggerFactory() {
        return new ApplicationLoggerFactoryImpl();
    }

    @Bean
    public CreateAreaUseCase createAreaUseCase(AreaRepository repository, ApplicationLoggerFactory loggerFactory) {
        return new CreateAreaUseCase(repository, loggerFactory);
    }

    @Bean
    public CreateSubAreaUseCase createSubAreaUseCase(
        SubAreaRepository subAreaRepository,
        AreaRepository areaRepository
    ) {
        return new CreateSubAreaUseCase(subAreaRepository, areaRepository);
    }

    @Bean
    public UpdateAreaUseCase updateAreaUseCase(AreaRepository repository) {
        return new UpdateAreaUseCase(repository);
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
