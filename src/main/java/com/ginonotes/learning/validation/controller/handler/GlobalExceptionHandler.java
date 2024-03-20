package com.ginonotes.learning.validation.controller.handler;

import com.ginonotes.learning.validation.controller.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * Global Exception Handler
 *
 * @author ginozhang
 * @since 2024/03/20
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final String ILLEGAL_PARAMETERS = "ILLEGAL_PARAMETERS";

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public <T> Response<T> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException occur!!!", e);
        return Response.fail(ILLEGAL_PARAMETERS,
                e.getBindingResult().getFieldErrors().stream()
                        .map(FieldError::getDefaultMessage).collect(Collectors.joining("; ")));
    }
}
