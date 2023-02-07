package com.networkMapping.installationLocation.controllers;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import com.networkMapping.installationLocation.controllers.exceptionsMapper.HttpMessageError;
import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.dtos.CreateAreaDto;
import com.networkMapping.installationLocation.dtos.CreateSubAreaDto;
import com.networkMapping.installationLocation.dtos.CreateSubAreaUseCaseDto;
import com.networkMapping.installationLocation.dtos.UpdateAreaRequestDto;
import com.networkMapping.installationLocation.useCases.CreateAreaUseCase;
import com.networkMapping.installationLocation.useCases.CreateSubAreaUseCase;
import com.networkMapping.installationLocation.useCases.GetAreasUseCase;
import com.networkMapping.installationLocation.useCases.GetSubAreasByParentIdUseCase;
import com.networkMapping.installationLocation.useCases.UpdateAreaUseCase;
import com.networkMapping.installationLocation.useCases.dtos.UpdateAreaDto;

@Path("/areas")
public class AreaResource {

    @Inject
    GetAreasUseCase getAreasUseCase;
    @Inject
    CreateAreaUseCase createAreaUseCase;
    @Inject
    UpdateAreaUseCase updateAreaUseCase;
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
    @APIResponses({
            @APIResponse(responseCode = "201", description = "Created", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Area.class))),
            @APIResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = HttpMessageError.class)))
    })

    public Area createArea(@Valid CreateAreaDto createAreaDto) throws Exception {
        return createAreaUseCase.execute(createAreaDto);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Area updateArea(@PathParam("id") UUID id, @Valid UpdateAreaRequestDto updateAreaRequestDto) {
        return updateAreaUseCase.execute(new UpdateAreaDto(id, updateAreaRequestDto.name));
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
