package com.hexagonal.arquitetura.application.util;

public enum Status {

    ENABLED("enabled"),
    DISABLED("disabled");

    private String status;

    private Status(String status){
        this.status = status;
    }

}
