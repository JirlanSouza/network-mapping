package com.networkMapping.networkDevice.external.database.repositories;

import com.networkMapping.networkDevice.external.database.models.NetworkPortModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface NetworkPortRepositoryJPA extends CrudRepository<NetworkPortModel, UUID> {
}
