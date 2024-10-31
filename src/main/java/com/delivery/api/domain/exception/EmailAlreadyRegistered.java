package com.delivery.api.domain.exception;

public class EmailAlreadyRegistered extends RuntimeException {

    public EmailAlreadyRegistered(String message){
        super(message);
    }

}
