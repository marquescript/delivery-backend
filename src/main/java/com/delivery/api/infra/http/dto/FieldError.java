package com.delivery.api.infra.http.dto;

public class FieldError {

    private String fieldName;
    private String messageError;

    public FieldError(String fieldName, String messageError) {
        this.fieldName = fieldName;
        this.messageError = messageError;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessageError() {
        return messageError;
    }
}
