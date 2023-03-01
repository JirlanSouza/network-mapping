package com.networkMapping.networkDevice.external.database.repositories;

import com.networkMapping.networkDevice.application.dtos.GetNetworkSwitchDto;
import com.networkMapping.networkDevice.application.repositories.NetworkDeviceRepository;
import com.networkMapping.networkDevice.domain.entities.NetworkPortType;
import com.networkMapping.networkDevice.domain.entities.NetworkSwitch;
import com.networkMapping.networkDevice.external.database.mappers.NetworkSwitchModelMapper;
import com.networkMapping.networkDevice.external.database.models.NetworkPortModel;
import com.networkMapping.networkDevice.external.database.models.NetworkPortTypeModel;
import com.networkMapping.networkDevice.external.database.models.NetworkSwitchModel;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class NetworkDeviceRepositoryImpl implements NetworkDeviceRepository {
    private final NetworkPortTypeRepositoryJPA networkPortTypeRepositoryJPA;
    private final NetworkPortRepositoryJPA networkPortRepositoryJPA;
    private final NetworkSwitchRepositoryJPA networkSwitchRepositoryJPA;

    public NetworkDeviceRepositoryImpl(
        NetworkPortTypeRepositoryJPA networkPortTypeRepositoryJPA,
        NetworkPortRepositoryJPA networkPortRepositoryJPA,
        NetworkSwitchRepositoryJPA networkSwitchRepositoryJPA
    ) {
        this.networkPortTypeRepositoryJPA = networkPortTypeRepositoryJPA;
        this.networkPortRepositoryJPA = networkPortRepositoryJPA;
        this.networkSwitchRepositoryJPA = networkSwitchRepositoryJPA;
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
        networkSwitchRepositoryJPA.save(new NetworkSwitchModel(networkSwitch));
        networkPortRepositoryJPA.saveAll(
            networkSwitch.getPorts().stream().map(port -> new NetworkPortModel(
                port, networkSwitch.getId()
            )).toList()
        );

    }

    @Override
    public List<GetNetworkSwitchDto> getSwitchesSummary() {
        return networkSwitchRepositoryJPA.getSummary()
            .stream().map(NetworkSwitchModelMapper::networkSwitchesDto)
            .toList();
    }

    @Override
    public Optional<GetNetworkSwitchDto> getSwitchSummary(UUID id) {
        return networkSwitchRepositoryJPA.findById(id).map(NetworkSwitchModelMapper::networkSwitchesDto);
    }
}
