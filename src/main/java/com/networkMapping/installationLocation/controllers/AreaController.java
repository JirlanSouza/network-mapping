package com.networkMapping.installationLocation.controllers;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.dtos.CreateAreaDto;
import com.networkMapping.installationLocation.dtos.CreateSubAreaDto;
import com.networkMapping.installationLocation.dtos.CreateSubAreaUseCaseDto;
import com.networkMapping.installationLocation.dtos.UpdateAreaRequestDto;
import com.networkMapping.installationLocation.useCases.*;
import com.networkMapping.installationLocation.useCases.dtos.UpdateAreaDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController(value = "areas")
@RequestMapping("/areas")
public class AreaController {

    final
    GetAreasUseCase getAreasUseCase;
    final
    CreateAreaUseCase createAreaUseCase;
    final
    UpdateAreaUseCase updateAreaUseCase;
    final
    GetSubAreasByParentIdUseCase getSubAreasByParentIdUseCase;
    final
    CreateSubAreaUseCase createSubAreaUseCase;

    public AreaController(
        GetAreasUseCase getAreasUseCase,
        CreateAreaUseCase createAreaUseCase,
        UpdateAreaUseCase updateAreaUseCase,
        GetSubAreasByParentIdUseCase getSubAreasByParentIdUseCase,
        CreateSubAreaUseCase createSubAreaUseCase
    ) {
        this.getAreasUseCase = getAreasUseCase;
        this.createAreaUseCase = createAreaUseCase;
        this.updateAreaUseCase = updateAreaUseCase;
        this.getSubAreasByParentIdUseCase = getSubAreasByParentIdUseCase;
        this.createSubAreaUseCase = createSubAreaUseCase;
    }

    @GetMapping
    public List<Area> getAreas() {
        return getAreasUseCase.execute();
    }

    @PostMapping
    public Area createArea(CreateAreaDto createAreaDto) throws Exception {
        return createAreaUseCase.execute(createAreaDto);
    }

    @PutMapping("/{id}")
    public Area updateArea(@PathVariable("id") UUID id, UpdateAreaRequestDto updateAreaRequestDto) {
        return updateAreaUseCase.execute(new UpdateAreaDto(id, updateAreaRequestDto.name));
    }

    @GetMapping("/{id}/sub-areas")
    public List<SubArea> GetSubAreasByParentId(@PathVariable("id") UUID areaId) throws RuntimeException {
        return getSubAreasByParentIdUseCase.execute(areaId);
    }

    @PostMapping("/{id}/sub-areas")
    public SubArea creatSubArea(@PathVariable("id") UUID id, CreateSubAreaDto createSubAreaDto) {
        return createSubAreaUseCase.execute(new CreateSubAreaUseCaseDto(createSubAreaDto.name, id));
    }

}
