package com.hexagonal.arquitetura.producer.controllers;

import com.hexagonal.arquitetura.application.product.ProductInterface;
import com.hexagonal.arquitetura.application.ports.service.ProductService;
import com.hexagonal.arquitetura.producer.dto.ProductDTO;
import com.hexagonal.arquitetura.producer.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable(value = "id") String id){
        ProductInterface product = service.get(id);
        return new ProductDTO(product);
    }

    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO product){
        ProductInterface productSave = service.create(product.getName(), product.getPrice());
        return ProductMapper.fromModel(productSave);
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable(value = "id") String id, @RequestBody ProductDTO product){
        ProductInterface productUpdate = service.update(id, ProductMapper.fromDTO(product));
        return ProductMapper.fromModel(productUpdate);
    }

    @PutMapping("/{id}/enable")
    public ProductDTO enable(@PathVariable(value = "id") String id){
        ProductInterface product = service.get(id);
        ProductInterface productEnable = service.enable(product);
        return ProductMapper.fromModel(productEnable);
    }

    @PutMapping("/{id}/disable")
    public ProductDTO disable(@PathVariable(value = "id") String id){
        ProductInterface product = service.get(id);
        ProductInterface productEnable = service.disable(product);
        return ProductMapper.fromModel(productEnable);
    }

}
