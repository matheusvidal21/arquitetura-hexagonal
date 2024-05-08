package com.hexagonal.arquitetura.producer.dto;

import com.hexagonal.arquitetura.application.product.ProductInterface;

public class ProductDTO {

    private String id;
    private String name;
    private Double price;
    private String status;

    public ProductDTO(){}

    public ProductDTO(ProductInterface product){
        this.id = product.getID();
        this.name = product.getName();
        this.price = product.getPrice();
        this.status = product.getStatus().name();
    }


    public ProductDTO(String id, String name, Double price, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
}
