package com.hexagonal.arquitetura.application.repository;

import java.util.List;

public interface GenericRepository<M,K>{
    List<M> findAll();

    M findById(K id);

    M save(M model);

}