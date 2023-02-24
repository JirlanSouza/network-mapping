package com.networkMapping.networkDevice.external.database.repositories;

import com.networkMapping.networkDevice.application.repositories.NetworkDeviceRepository;
import com.networkMapping.networkDevice.domain.NetworkPortType;
import com.networkMapping.networkDevice.domain.NetworkSwitch;
import com.networkMapping.networkDevice.external.database.models.NetworkPortTypeModel;
import com.networkMapping.networkDevice.external.database.models.NetworkPortModel;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class NetworkDeviceRepositoryImpl implements NetworkDeviceRepository {
    private final NetworkPortTypeRepositoryJPA networkPortTypeRepositoryJPA;
    private final NetworkPortRepositoryJPA networkPortRepositoryJPA;

    public NetworkDeviceRepositoryImpl(NetworkPortTypeRepositoryJPA networkPortTypeRepositoryJPA, NetworkPortRepositoryJPA networkPortRepositoryJPA) {
        this.networkPortTypeRepositoryJPA = networkPortTypeRepositoryJPA;
        this.networkPortRepositoryJPA = networkPortRepositoryJPA;
    }

    @Override
    public boolean existsPortType(NetworkPortType portType) {
        return networkPortTypeRepositoryJPA.existsById(portType.getId());
    }

    @Override
    public void savePortType(NetworkPortType portType) {
        networkPortTypeRepositoryJPA.save(new NetworkPortTypeModel(portType));
    }

    @Override
    public Optional<NetworkPortType> getPortType(UUID id) {
        return networkPortTypeRepositoryJPA.findById(id)
            .map(NetworkPortTypeModel::toEntity);
    }

    @Override
    @Transactional
    public void saveSwitch(NetworkSwitch networkSwitch) {
        networkPortRepositoryJPA.saveAll (
            networkSwitch.getPorts().stream().map(NetworkPortModel::new).toList()
        );
    }
}
