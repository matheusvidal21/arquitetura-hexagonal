package com.hexagonal.arquitetura.application.exception;

public class StatusException extends RuntimeException{

    public StatusException(String message){
        super(message);
    }

}
