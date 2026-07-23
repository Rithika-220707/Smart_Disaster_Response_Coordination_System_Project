package com.sfl.mission_service.exception;

public class MissionNotFoundException extends RuntimeException{
    public MissionNotFoundException(String message){
        super(message);
    }
}
