package com.hexagonal.arquitetura.application.product;

import com.hexagonal.arquitetura.application.util.Status;

public interface ProductInterface {
    public Boolean isValid();
    public void enable();
    public void disable();
    public String getID();
    public String getName();
    public Status getStatus();
    public Double getPrice();
    public void setID(String id);
    public void setName(String name);
    public void setStatus(Status status);
    public void setPrice(Double price);

}
