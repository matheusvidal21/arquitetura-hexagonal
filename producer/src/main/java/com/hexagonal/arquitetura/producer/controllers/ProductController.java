package com.hexagonal.arquitetura.producer.controllers;

import com.hexagonal.arquitetura.application.product.ProductInterface;
import com.hexagonal.arquitetura.application.service.ProductService;
import com.hexagonal.arquitetura.producer.dto.ProductDTO;
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
        return new ProductDTO(productSave);
    }


}
