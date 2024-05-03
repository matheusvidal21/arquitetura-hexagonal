package com.hexagonal.arquitetura.util;

public enum Status {

    ENABLED("enabled"),
    DISABLED("disabled");

    private String status;

    private Status(String status){
        this.status = status;
    }

}
