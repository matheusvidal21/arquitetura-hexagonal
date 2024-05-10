package com.hexagonal.arquitetura.adapters.repositories;

import com.hexagonal.arquitetura.adapters.mapper.GenericEntityMapper;
import com.hexagonal.arquitetura.application.ports.repository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.ArrayList;
import java.util.List;

@NoRepositoryBean
public class AbstractRepository<M, K, E, R extends JpaRepository<E, K>, G extends GenericEntityMapper<M,E>> implements GenericRepository<M,K> {

    protected G entityMapper;
    protected R jpaRepository;

    public AbstractRepository(G entityMapper, R jpaRepository) {
        this.entityMapper = entityMapper;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<M> findAll() {
        List<M> list = new ArrayList<>();
        jpaRepository.findAll().forEach(entity -> list.add(entityMapper.fromEntity(entity)));
        return list;
    }

    @Override
    public M findById(K id) {
        return entityMapper.fromEntity(jpaRepository.findById(id).orElse(null));
    }

    @Override
    public M save(M model){
        E entity = entityMapper.fromModel(model);
        return entityMapper.fromEntity(jpaRepository.save(entity));
    }
}
