package com.sfl.mission_service.exception;

public class ResourceUnavailableException extends RuntimeException{
    public ResourceUnavailableException(String message){
        super(message);
    }
}
