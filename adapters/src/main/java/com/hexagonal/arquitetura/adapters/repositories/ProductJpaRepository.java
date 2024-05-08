package com.hexagonal.arquitetura.adapters.repositories;

import com.hexagonal.arquitetura.adapters.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, String> {

}
