package com.networkMapping.networkDevice.external.database.repositories;

import com.networkMapping.networkDevice.external.database.models.NetworkPortModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NetworkPortRepositoryJPA extends CrudRepository<NetworkPortModel, UUID> {
}
