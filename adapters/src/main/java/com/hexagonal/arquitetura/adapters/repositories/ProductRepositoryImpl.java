package com.hexagonal.arquitetura.adapters.repositories;

import com.hexagonal.arquitetura.adapters.entities.ProductEntity;
import com.hexagonal.arquitetura.adapters.mapper.MapperProduct;
import com.hexagonal.arquitetura.application.product.ProductInterface;
import com.hexagonal.arquitetura.application.repository.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl extends AbstractRepositoryImpl<ProductInterface, String, ProductEntity, ProductJpaRepository, MapperProduct> implements ProductRepository {
    public ProductRepositoryImpl(MapperProduct entityMapper, ProductJpaRepository jpaRepository) {
        super(entityMapper, jpaRepository);
    }
}
