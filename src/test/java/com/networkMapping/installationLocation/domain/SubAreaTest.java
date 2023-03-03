package com.networkMapping.installationLocation.domain;

import com.networkMapping.installationLocation.domain.exceptions.InvalidSubAreaIdException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SubAreaTest {

    @Test
    public void shouldCreateNewSubArea() {
        var parentId = UUID.randomUUID();
        var subArea = new SubArea("SUB_AREA001", parentId);

        assertNotNull(subArea.getId());
        assertEquals(subArea.getName(), "SUB_AREA001");
        assertEquals(subArea.getParentId(), parentId);
    }

    @Test
    public void shouldCreateSubAreaWithExistentData() {
        var id = UUID.randomUUID();
        var name = "SUB_AREA001";
        var parentId = UUID.randomUUID();
        var subArea = new SubArea(id, name, parentId);

        assertEquals(subArea.getId(), id);
        assertEquals(subArea.getName(), "SUB_AREA001");
        assertEquals(subArea.getParentId(), parentId);
    }

    @Test
    public void shouldThrowExceptionWhenCreateNewSubAreaWithEqualsIdAndParentId() {
        var id = UUID.randomUUID();
        var name = "SUB_AREA001";

        assertThrows(InvalidSubAreaIdException.class, () -> new SubArea(id, name, id));
    }

}