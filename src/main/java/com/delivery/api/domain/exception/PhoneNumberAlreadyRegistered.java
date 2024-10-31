package com.delivery.api.domain.exception;

public class PhoneNumberAlreadyRegistered extends RuntimeException {

    public PhoneNumberAlreadyRegistered(String message){
        super(message);
    }

}
