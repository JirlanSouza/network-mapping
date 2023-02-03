package com.networkMapping.installationLocation.resouces;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.dtos.CreateAreaDto;
import com.networkMapping.installationLocation.useCases.CreateAreaUseCase;
import com.networkMapping.installationLocation.useCases.GetAreasUseCase;

@Path("/areas")
public class AreaResource {

    final GetAreasUseCase getAreasUseCase;
    final CreateAreaUseCase createAreaUseCase;

    public AreaResource(GetAreasUseCase getAreasUseCase, CreateAreaUseCase createAreaUseCase) {
        this.getAreasUseCase = getAreasUseCase;
        this.createAreaUseCase = createAreaUseCase;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Area> getAreas() {
        return getAreasUseCase.execute();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Area createArea(@Valid CreateAreaDto createAraDto) throws Exception {
        return createAreaUseCase.execute(createAraDto);
    }

}
