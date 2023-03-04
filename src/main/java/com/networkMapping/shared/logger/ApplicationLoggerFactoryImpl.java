package com.networkMapping.shared.logger;

import org.slf4j.LoggerFactory;

public class ApplicationLoggerFactoryImpl implements ApplicationLoggerFactory {
    @Override
    public ApplicationLogger getLogger(Class name) {
        return new ApplicationLoggerImpl(LoggerFactory.getLogger(name.getName()));
    }
}
