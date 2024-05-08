package com.hexagonal.arquitetura.adapters.services;

import com.hexagonal.arquitetura.application.exception.PriceException;
import com.hexagonal.arquitetura.application.product.Product;
import com.hexagonal.arquitetura.application.product.ProductInterface;
import com.hexagonal.arquitetura.application.repository.ProductRepository;
import com.hexagonal.arquitetura.application.service.ProductService;

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
            return new Product();
        }
        return repository.save(product);
    }

    @Override
    public ProductInterface enable(ProductInterface product){
        try {
            product.enable();
            return repository.save(product);
        } catch (PriceException e){
            return new Product();
        }
    }

    @Override
    public ProductInterface disable(ProductInterface product){
        try {
            product.disable();
            return repository.save(product);
        } catch (PriceException e){
            return new Product();
        }
    }
}
