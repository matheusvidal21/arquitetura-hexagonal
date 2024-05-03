package com.hexagonal.arquitetura.product;

public interface ProductServiceInterface {

    ProductInterface get(String id);
    ProductInterface create(String name, Double price);
    ProductInterface enable(ProductInterface product);
    ProductInterface disable(ProductInterface product);

}
