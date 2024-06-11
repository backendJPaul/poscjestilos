package com.jpaul.poscjestilos.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String RESOURCE_NOT_FOUND_BY_ID  = "Resource not found by id";

    public ResourceNotFoundException(String message){
        super(message);
    }
    public ResourceNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
}
