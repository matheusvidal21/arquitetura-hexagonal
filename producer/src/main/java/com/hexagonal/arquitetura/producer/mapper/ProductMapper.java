package com.hexagonal.arquitetura.producer.mapper;

import com.hexagonal.arquitetura.application.product.Product;
import com.hexagonal.arquitetura.application.product.ProductInterface;
import com.hexagonal.arquitetura.producer.dto.ProductDTO;

public class ProductMapper {

    public static ProductInterface fromDTO(ProductDTO dto){
        ProductInterface product = new Product();
        product.setID(dto.getId());
        product.setPrice(dto.getPrice());
        product.setName(dto.getName());
        return product;
    }

    public static ProductDTO fromModel(ProductInterface product){
        return new ProductDTO(product);
    }
}
