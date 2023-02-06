package com.networkMapping.installationLocation.controllers;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.dtos.CreateAreaDto;
import com.networkMapping.installationLocation.dtos.CreateSubAreaDto;
import com.networkMapping.installationLocation.dtos.CreateSubAreaUseCaseDto;
import com.networkMapping.installationLocation.useCases.CreateAreaUseCase;
import com.networkMapping.installationLocation.useCases.CreateSubAreaUseCase;
import com.networkMapping.installationLocation.useCases.GetAreasUseCase;
import com.networkMapping.installationLocation.useCases.GetSubAreasByParentIdUseCase;

@Path("/areas")
public class AreaResource {

    @Inject
    GetAreasUseCase getAreasUseCase;
    @Inject
    CreateAreaUseCase createAreaUseCase;
    @Inject
    GetSubAreasByParentIdUseCase getSubAreasByParentIdUseCase;
    @Inject
    CreateSubAreaUseCase createSubAreaUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Area> getAreas() {
        return getAreasUseCase.execute();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Area createArea(@Valid CreateAreaDto createAreaDto) throws Exception {
        return createAreaUseCase.execute(createAreaDto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/sub-areas")
    public List<SubArea> GetSubAreasByParentId(@PathParam("id") UUID areaId) throws Exception {
        return getSubAreasByParentIdUseCase.execute(areaId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}/sub-areas")
    public SubArea creatSubArea(@PathParam("id") UUID id, @Valid CreateSubAreaDto createSubAreaDto) {
        return createSubAreaUseCase.execute(new CreateSubAreaUseCaseDto(createSubAreaDto.name, id));
    }

}
