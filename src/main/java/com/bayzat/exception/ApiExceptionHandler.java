package com.bayzat.exception;

import com.bayzat.utility.ErrorConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebInputException;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public Object handleException(Exception exception) {
        log.error("Something went wrong: ", exception);
        return new ErrorInfo(ErrorConstants.SERVICE_EXCEPTION, ErrorConstants.SERVICE_EXCEPTION_MESSAGE);
    }


    @ExceptionHandler(ApiException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public Object handleCustomException(ApiException ex) {
        log.error("ApiException thrown: ", ex);
        return new ErrorInfo(ErrorConstants.INVALID_INPUT, ErrorConstants.INVALID_INPUT_MESSAGE);
    }

}
