package com.hexagonal.arquitetura.application.service;

import java.util.List;

public interface GenericService <M, K> {

    List<M> getAll();
    M get(K id);

}
