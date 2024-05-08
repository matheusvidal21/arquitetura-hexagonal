package com.hexagonal.arquitetura.application.service;

import com.hexagonal.arquitetura.application.product.ProductInterface;

public interface ProductService extends GenericService<ProductInterface, String> {
    ProductInterface create(String name, Double price);
    ProductInterface enable(ProductInterface product);
    ProductInterface disable(ProductInterface product);
}
