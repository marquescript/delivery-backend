package com.delivery.api.infra.http.handler.exceptions;

import com.delivery.api.domain.exception.EntityNotFound;
import com.delivery.api.infra.http.dto.CustomError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<CustomError> entityNotFoundException(EntityNotFound exception, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError error = new CustomError(
                Instant.now(), status.value(), exception.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(status).body(error);
    }

}
