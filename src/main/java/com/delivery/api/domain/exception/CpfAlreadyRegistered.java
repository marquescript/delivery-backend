package com.delivery.api.domain.exception;

public class CpfAlreadyRegistered extends RuntimeException {

    public CpfAlreadyRegistered(String message){
        super(message);
    }

}
