package com.hexagonal.arquitetura.product;

import com.hexagonal.arquitetura.util.Status;

public interface ProductInterface {
    public Boolean isValid();
    public void enable();
    public void disable();
    public String getID();
    public String getName();
    public Status getStatus();
    public Double getPrice();

}
