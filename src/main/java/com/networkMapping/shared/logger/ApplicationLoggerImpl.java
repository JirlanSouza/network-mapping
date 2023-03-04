package com.networkMapping.shared.logger;

import org.slf4j.Logger;

public class ApplicationLoggerImpl implements ApplicationLogger {

    private final Logger logger;

    protected ApplicationLoggerImpl(Logger logger) {
        this.logger = logger;
    }


    @Override
    public void info(String msg) {
        logger.info(msg);
    }

    @Override
    public void debug(String msg) {
        logger.debug(msg);
    }

    @Override
    public void warn(String msg) {
        logger.warn(msg);
    }

    @Override
    public void error(Exception exception) {
        logger.error(exception.getMessage());
    }
}
