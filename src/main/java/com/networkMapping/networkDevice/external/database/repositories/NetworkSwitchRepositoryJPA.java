package com.networkMapping.networkDevice.external.database.repositories;

import com.networkMapping.networkDevice.external.database.models.NetworkSwitchModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface NetworkSwitchRepositoryJPA extends CrudRepository<NetworkSwitchModel, UUID> {
    @Query(value = """
        select s from NetworkSwitchModel s
        left join NetworkPortModel p on s.id = p.parentId
        left join NetworkPortTypeModel t on p.portTypeId = t.id
        join SubAreaModel sa on s.installationLocal.id = sa.id
        """)
    List<NetworkSwitchModel> getSummary();
}
