package com.networkMapping.shared.logger;

public interface ApplicationLoggerFactory {
    ApplicationLogger getLogger(Class name);
}
