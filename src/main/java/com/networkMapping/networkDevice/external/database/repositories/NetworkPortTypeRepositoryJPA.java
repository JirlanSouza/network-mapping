package com.networkMapping.networkDevice.external.database.repositories;

import com.networkMapping.networkDevice.external.database.models.NetworkPortTypeModel;
import com.networkMapping.networkDevice.external.database.models.NetworkPortTypeModelId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkPortTypeRepositoryJPA extends CrudRepository<NetworkPortTypeModel, NetworkPortTypeModelId> {
}
