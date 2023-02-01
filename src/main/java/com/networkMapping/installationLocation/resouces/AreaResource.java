package com.networkMapping.installationLocation.resouces;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.dtos.CreateAreaDto;
import com.networkMapping.installationLocation.useCases.CreateAreaUseCase;

@Path("/areas")
public class AreaResource {

    private CreateAreaUseCase createAreaUseCase;

    public AreaResource(CreateAreaUseCase createAreaUseCase) {
        this.createAreaUseCase = createAreaUseCase;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Area createArea(@Valid CreateAreaDto createAraDto) throws Exception {
        return createAreaUseCase.execute(createAraDto);
    }

}
