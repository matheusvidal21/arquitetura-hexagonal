package com.hexagonal.arquitetura.adapters.services;

import com.hexagonal.arquitetura.application.exception.PriceException;
import com.hexagonal.arquitetura.application.product.Product;
import com.hexagonal.arquitetura.application.product.ProductInterface;
import com.hexagonal.arquitetura.application.ports.repository.ProductRepository;
import com.hexagonal.arquitetura.application.ports.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public List<ProductInterface> getAll() {
        return repository.findAll();
    }

    @Override
    public ProductInterface get(String id){
        return repository.findById(id);
    }

    @Override
    public ProductInterface create(String name, Double price){
        ProductInterface product = new Product();
        product.setName(name);
        product.setPrice(price);
        if(!product.isValid()){
            throw new IllegalArgumentException("Não foi possível criar um produto");
        }
        return repository.save(product);
    }

    @Override
    public ProductInterface update(String id, ProductInterface product){
        ProductInterface productInterface = repository.update(id, product);
        if(!productInterface.isValid()){
            throw new IllegalArgumentException("Não foi possível atualizar um produto");
        }
        return productInterface;
    }

    @Override
    public ProductInterface enable(ProductInterface product){
        try {
            product.enable();
            return repository.save(product);
        } catch (PriceException e){
            throw new PriceException("O preço deve ser mais que zero para o produto ser habilitado");
        }
    }

    @Override
    public ProductInterface disable(ProductInterface product){
        try {
            product.disable();
            return repository.save(product);
        } catch (PriceException e){
            throw new PriceException("O preço deve ser zero para o produto ser desabilitado");
        }
    }
}
