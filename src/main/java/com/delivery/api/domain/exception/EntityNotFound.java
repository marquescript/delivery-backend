package com.delivery.api.domain.exception;

public class EntityNotFound extends RuntimeException{

    public EntityNotFound(String message){
        super(message);
    }

}
