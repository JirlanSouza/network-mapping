package com.networkMapping.installationLocation.domain;

import com.networkMapping.installationLocation.domain.entities.Area;
import com.networkMapping.installationLocation.domain.entities.SubArea;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AreaTest {

    @Test
    public void shouldCreateNewArea() {
        var area = new Area("AREA001");

        assertNotNull(area.getId());
        assertEquals(area.getName(), "AREA001");
        assertEquals(area.getSubAreas().size(), 0);
    }

    @Test
    public void shouldCreateAreaWithExistentData() {
        var id = UUID.randomUUID();
        var name = "AREA001";
        var subAreas = new ArrayList<SubArea>();
        subAreas.add(new SubArea("SUB_AREA001", id));
        var area = new Area(id, name, subAreas);

        assertEquals(area.getId(), id);
        assertEquals(area.getName(), "AREA001");
        assertEquals(area.getSubAreas().size(), 1);
    }

}