package com.networkMapping.common.advises;

import com.networkMapping.networkDevice.domain.exceptions.InvalidNetworkPortSequence;
import com.networkMapping.shared.exceptions.AlreadyExistsEntityException;
import com.networkMapping.shared.exceptions.NotFoundEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationControllerAdvise extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundEntityException.class})
    protected ErrorResponse handleNotFoundError(RuntimeException exception) {
        return new ErrorResponseException(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(value = {InvalidNetworkPortSequence.class})
    protected ErrorResponse handleBadRequestError(RuntimeException exception, WebRequest request) {
        return new ErrorResponseException(HttpStatus.BAD_REQUEST, exception);
    }

    @ExceptionHandler(value = {AlreadyExistsEntityException.class})
    protected ErrorResponse handleConflictError(RuntimeException exception) {
        return new ErrorResponseException(HttpStatus.CONFLICT, exception);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ErrorResponse handleInternalError(Exception exception) {
        return new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }
}
