package com.networkMapping.networkDevice.external.database.repositories;

import com.networkMapping.networkDevice.external.database.models.NetworkSwitchModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface NetworkSwitchRepositoryJPA extends CrudRepository<NetworkSwitchModel, UUID> {
    @Query(value = """
        select s from NetworkSwitchModel s
        join fetch SubAreaModel sa
        join fetch NetworkPortModel p
        join fetch NetworkPortTypeModel t
        """)
    List<NetworkSwitchModel> getSummary();
}
