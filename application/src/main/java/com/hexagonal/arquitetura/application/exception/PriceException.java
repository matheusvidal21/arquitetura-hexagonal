package com.hexagonal.arquitetura.application.exception;

public class PriceException extends RuntimeException{

    public PriceException(String message){
        super(message);
    }

}
