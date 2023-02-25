package com.networkMapping.networkDevice.external.database.repositories;

import com.networkMapping.networkDevice.external.database.models.NetworkSwitchModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface NetworkSwitchRepositoryJPA extends CrudRepository<NetworkSwitchModel, UUID> {
}
