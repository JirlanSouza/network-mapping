package com.networkMapping.shared.logger;

import org.slf4j.Logger;

public interface ApplicationLogger {
    void info(String msg);
    void debug(String msg);
    void warn(String msg);
    void error(Exception exception);
}
