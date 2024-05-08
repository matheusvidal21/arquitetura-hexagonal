package com.hexagonal.arquitetura.producer.configuration;

import com.hexagonal.arquitetura.adapters.services.ProductServiceImpl;
import com.hexagonal.arquitetura.application.repository.ProductRepository;
import com.hexagonal.arquitetura.application.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.hexagonal.arquitetura.adapters"})
public class ServicesConfiguration {


    private ProductRepository productRepository;

    public ServicesConfiguration(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    public ProductService productService(){
        return new ProductServiceImpl(productRepository);
    }

}
