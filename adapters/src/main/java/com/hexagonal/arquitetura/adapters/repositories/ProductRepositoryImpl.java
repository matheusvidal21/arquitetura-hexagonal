package com.hexagonal.arquitetura.adapters.repositories;

import com.hexagonal.arquitetura.adapters.entities.ProductEntity;
import com.hexagonal.arquitetura.adapters.mapper.MapperProduct;
import com.hexagonal.arquitetura.application.product.ProductInterface;
import com.hexagonal.arquitetura.application.ports.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductRepositoryImpl extends AbstractRepository<ProductInterface, String, ProductEntity, ProductJpaRepository, MapperProduct> implements ProductRepository {


    public ProductRepositoryImpl(MapperProduct entityMapper, ProductJpaRepository jpaRepository) {
        super(entityMapper, jpaRepository);
    }

    @Override
    public ProductInterface update(String id, ProductInterface product){
        Optional<ProductEntity> entity = jpaRepository.findById(id);

        if(entity.isPresent()){
            entity.get().setName(product.getName());
            entity.get().setPrice(product.getPrice());
            ProductEntity entitySave = jpaRepository.save(entity.get());
            return entityMapper.fromEntity(entitySave);
        }else{
            throw new IllegalArgumentException("Produto com o id " + id + " não existe");
        }


    }

}
