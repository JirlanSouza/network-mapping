package com.networkMapping.networkDevice.external.database.repositories;

import com.networkMapping.networkDevice.application.repositories.NetworkDeviceRepository;
import com.networkMapping.networkDevice.domain.NetworkPortType;
import com.networkMapping.networkDevice.external.database.models.NetworkPortTypeModel;
import com.networkMapping.networkDevice.external.database.models.NetworkPortTypeModelId;
import org.springframework.stereotype.Repository;

@Repository
public class NetworkDeviceRepositoryImpl implements NetworkDeviceRepository {
    private final NetworkPortTypeRepositoryJPA networkPortTypeRepositoryJPA;

    public NetworkDeviceRepositoryImpl(NetworkPortTypeRepositoryJPA networkPortTypeRepositoryJPA) {
        this.networkPortTypeRepositoryJPA = networkPortTypeRepositoryJPA;
    }

    @Override
    public boolean existsPortType(NetworkPortType portType) {
        return networkPortTypeRepositoryJPA.existsById(new NetworkPortTypeModelId(portType.name(), portType.speed()));
    }

    @Override
    public void savePortType(NetworkPortType portType) {
        networkPortTypeRepositoryJPA.save(new NetworkPortTypeModel(portType));
    }
}
