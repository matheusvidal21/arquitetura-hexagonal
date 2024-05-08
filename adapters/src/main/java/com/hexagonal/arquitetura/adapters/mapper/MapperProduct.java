package com.hexagonal.arquitetura.adapters.mapper;

import com.hexagonal.arquitetura.adapters.entities.ProductEntity;
import com.hexagonal.arquitetura.application.product.Product;
import com.hexagonal.arquitetura.application.product.ProductInterface;
import com.hexagonal.arquitetura.application.util.Status;
import org.springframework.stereotype.Component;

@Component
public class MapperProduct implements GenericEntityMapper<ProductInterface, ProductEntity> {

    @Override
    public ProductInterface fromEntity(ProductEntity entity){
        Product product = new Product();
        product.setID(entity.getId());
        product.setPrice(entity.getPrice());
        product.setName(entity.getName());
        product.setStatus(Status.valueOf(entity.getStatus()));
        return product;
    }

    @Override
    public ProductEntity fromModel(ProductInterface product){
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getID());
        entity.setStatus(product.getStatus().name());
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        return entity;
    }

}
