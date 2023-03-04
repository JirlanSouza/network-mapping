package com.networkMapping.networkDevice.domain.valueObjects;

import com.networkMapping.networkDevice.domain.exceptions.InvalidDataSpeedValueException;

public record DataSpeed(int value) {
    public DataSpeed(int value) {
        if (value < 0) {
            throw new InvalidDataSpeedValueException("the data value value: %d is invalid".formatted(value));
        }
        this.value = value;
    }
}
