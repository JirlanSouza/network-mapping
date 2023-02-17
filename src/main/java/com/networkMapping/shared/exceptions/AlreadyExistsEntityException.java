package com.networkMapping.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class AlreadyExistsEntityException extends RuntimeException {

    public AlreadyExistsEntityException() {
        super();
    }

    public AlreadyExistsEntityException(String message) {
        super(message);
    }

}
