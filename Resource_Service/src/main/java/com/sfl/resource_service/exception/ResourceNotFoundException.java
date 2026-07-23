package com.sfl.resource_service.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String id){
        super("Resource not found with id"+id);
    }
}
