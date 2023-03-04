package com.networkMapping.installationLocation.domain.valueObjects;

import com.networkMapping.installationLocation.domain.exceptions.InvalidLocationNameException;

public record LocationName(String value) {
    public LocationName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.isBlank() || value.length() < 3) {
            throw new InvalidLocationNameException("the name: %s is invalid, it should have over 3 character".formatted(value));
        }
    }
}
