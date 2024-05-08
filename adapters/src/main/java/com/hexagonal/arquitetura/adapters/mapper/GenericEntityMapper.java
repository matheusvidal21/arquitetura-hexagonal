package com.hexagonal.arquitetura.adapters.mapper;

public interface GenericEntityMapper <M,E>{

    M fromEntity(E entity);
    E fromModel(M model);

}
