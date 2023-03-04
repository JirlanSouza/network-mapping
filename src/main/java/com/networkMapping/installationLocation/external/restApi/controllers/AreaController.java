package com.networkMapping.installationLocation.external.restApi.controllers;

import com.networkMapping.installationLocation.application.dtos.CreateAreaDto;
import com.networkMapping.installationLocation.application.dtos.CreateSubAreaDto;
import com.networkMapping.installationLocation.application.dtos.UpdateAreaDto;
import com.networkMapping.installationLocation.application.presenters.AreaDataPresenter;
import com.networkMapping.installationLocation.application.presenters.SubAreaDataPresenter;
import com.networkMapping.installationLocation.application.useCases.*;
import com.networkMapping.installationLocation.domain.Area;
import com.networkMapping.installationLocation.domain.SubArea;
import com.networkMapping.installationLocation.external.restApi.requestDtos.CreateAreaRequestDto;
import com.networkMapping.installationLocation.external.restApi.requestDtos.CreateSubAreaRequestDto;
import com.networkMapping.installationLocation.external.restApi.requestDtos.UpdateAreaRequestDto;
import jakarta.validation.Valid;
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
    public Area createArea(@RequestBody @Valid CreateAreaRequestDto requestDto) throws Exception {
        return createAreaUseCase.execute(new CreateAreaDto(requestDto.name()));
    }

    @PutMapping("/{id}")
    public Area updateArea(@PathVariable("id") UUID id, @RequestBody @Valid UpdateAreaRequestDto requestDto) {
        System.out.println(requestDto);
        return updateAreaUseCase.execute(new UpdateAreaDto(id, requestDto.name()));
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
    public SubArea creatSubArea(@PathVariable("id") UUID id, CreateSubAreaRequestDto requestDto) {
        return createSubAreaUseCase.execute(new CreateSubAreaDto(requestDto.name(), id));
    }
}
