package com.networkMapping.installationLocation.controllers;

import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.dtos.CreateAreaDto;
import com.networkMapping.installationLocation.dtos.CreateSubAreaDto;
import com.networkMapping.installationLocation.dtos.CreateSubAreaUseCaseDto;
import com.networkMapping.installationLocation.dtos.UpdateAreaRequestDto;
import com.networkMapping.installationLocation.useCases.*;
import com.networkMapping.installationLocation.useCases.dtos.UpdateAreaDto;
import com.networkMapping.installationLocation.useCases.presenters.AreaDataPresenter;
import com.networkMapping.installationLocation.useCases.presenters.SubAreaDataPresenter;
import com.networkMapping.installationLocation.useCases.GetAreaUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController(value = "areas")
@RequestMapping("/areas")
public class AreaController {
    private final GetAreaUseCase getAreaUseCase;
    private final GetAreasUseCase getAreasUseCase;
    private final CreateAreaUseCase createAreaUseCase;
    private final UpdateAreaUseCase updateAreaUseCase;
    private final GetSubAreasByParentIdUseCase getSubAreasByParentIdUseCase;
    private final GetSubAreaUseCase getSubAreaUseCase;
    private final CreateSubAreaUseCase createSubAreaUseCase;

    public AreaController(
        GetAreaUseCase getAreaUseCase,
        GetAreasUseCase getAreasUseCase,
        CreateAreaUseCase createAreaUseCase,
        UpdateAreaUseCase updateAreaUseCase,
        GetSubAreasByParentIdUseCase getSubAreasByParentIdUseCase,
        GetSubAreaUseCase getSubAreaUseCase,
        CreateSubAreaUseCase createSubAreaUseCase
    ) {
        this.getAreaUseCase = getAreaUseCase;
        this.getAreasUseCase = getAreasUseCase;
        this.createAreaUseCase = createAreaUseCase;
        this.updateAreaUseCase = updateAreaUseCase;
        this.getSubAreasByParentIdUseCase = getSubAreasByParentIdUseCase;
        this.getSubAreaUseCase = getSubAreaUseCase;
        this.createSubAreaUseCase = createSubAreaUseCase;
    }

    @GetMapping
    public List<AreaDataPresenter> getAreas() {
        return getAreasUseCase.execute();
    }

    @GetMapping("/{id}")
    public AreaDataPresenter getArea(@PathVariable("id") UUID id) {
        return getAreaUseCase.execute(id);
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
    public List<SubAreaDataPresenter> GetSubAreasByParentId(@PathVariable("id") UUID areaId) throws RuntimeException {
        return getSubAreasByParentIdUseCase.execute(areaId);
    }

    @GetMapping("/sub-areas/{id}")
    public SubAreaDataPresenter getSubArea(@PathVariable("id") UUID id) {
        return getSubAreaUseCase.execute(id);
    }

    @PostMapping("/{id}/sub-areas")
    public SubArea creatSubArea(@PathVariable("id") UUID id, CreateSubAreaDto createSubAreaDto) {
        return createSubAreaUseCase.execute(new CreateSubAreaUseCaseDto(createSubAreaDto.name, id));
    }
}
