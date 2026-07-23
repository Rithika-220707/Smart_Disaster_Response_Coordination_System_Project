package com.sfl.rescue_team_service.exception;

public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException (Long id){
        super("Rescue Team not found "+id);
    }
}
