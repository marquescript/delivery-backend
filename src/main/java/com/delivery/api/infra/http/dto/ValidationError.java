package com.delivery.api.infra.http.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

    private List<FieldError> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String message, String path) {
        super(timestamp, status, message, path);
    }

    public void addError(String fieldName, String messageError) {
        errors.add(new FieldError(fieldName, messageError));
    }

}
