package com.networkMapping.common.advises;

import com.networkMapping.installationLocation.domain.exceptions.InvalidSubAreaIdException;
import com.networkMapping.networkDevice.domain.exceptions.DuplicatedNetworkPortNumberException;
import com.networkMapping.networkDevice.domain.exceptions.InvalidNetworkPortSequence;
import com.networkMapping.networkDevice.domain.exceptions.InvalidNetworkSwitchConnectionException;
import com.networkMapping.shared.exceptions.AlreadyExistsEntityException;
import com.networkMapping.shared.exceptions.NotFoundEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@ControllerAdvice
public class ApplicationControllerAdvise extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundEntityException.class})
    protected ProblemDetail handleNotFoundError(RuntimeException exception) {
        return getDetail(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(value = {
        InvalidNetworkPortSequence.class, InvalidNetworkSwitchConnectionException.class,
        InvalidSubAreaIdException.class
    })
    protected ProblemDetail handleBadRequestError(RuntimeException exception, WebRequest request) {
        return getDetail(HttpStatus.BAD_REQUEST, exception);
    }

    @ExceptionHandler(value = {AlreadyExistsEntityException.class, DuplicatedNetworkPortNumberException.class})
    protected ProblemDetail handleConflictError(RuntimeException exception) {
        return getDetail(HttpStatus.CONFLICT, exception);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ErrorResponse handleInternalError(Exception exception) {
        return new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

    private ProblemDetail getDetail(HttpStatus status, Exception exception) {
        var detail = ProblemDetail.forStatus(status);
        detail.setType(URI.create(exception.getClass().getSimpleName()));
        detail.setDetail(exception.getMessage());
        return detail;
    }
}
