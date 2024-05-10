package com.hexagonal.arquitetura.application.ports.repository;

import com.hexagonal.arquitetura.application.product.ProductInterface;

public interface ProductRepository extends GenericRepository<ProductInterface, String> {

    ProductInterface update(String id, ProductInterface product);

}
