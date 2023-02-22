package com.networkMapping.networkDevice.application.repositories;

import com.networkMapping.networkDevice.domain.NetworkPortType;

public interface NetworkDeviceRepository {
    boolean existsPortType(NetworkPortType portType);
    void savePortType(NetworkPortType portType);
}
