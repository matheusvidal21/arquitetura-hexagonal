package com.hexagonal.arquitetura.product;

import com.hexagonal.arquitetura.exception.PriceException;
import com.hexagonal.arquitetura.exception.StatusException;
import com.hexagonal.arquitetura.util.Status;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.UUID;

import java.util.HashSet;
import java.util.Set;

public class Product implements ProductInterface{

    @NotBlank
    @UUID
    private String ID;

    @NotBlank
    private String name;

    @NotNull
    private Status status;

    @NotNull
    @PositiveOrZero
    private Double price;

    public Product(){
        this.ID = java.util.UUID.randomUUID().toString();
        this.status = Status.DISABLED;
    }


    @Override
    public Boolean isValid() {
        if(status == null) {
            status = Status.DISABLED;
        }

        if(status != Status.ENABLED && status != Status.DISABLED){
            throw new StatusException("The status must be enabled or disabled");
        }

        if(price < 0.0){
            throw new PriceException("The price must be greater or equal zero");
        }

        Set<String> errors = validar();
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Erros de validação: " + errors);
        }

        return true;
    }

    private Set<String> validar() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Product>> violations = validator.validate(this);

        Set<String> errors = new HashSet<>();
        for (ConstraintViolation<Product> violation : violations) {
            errors.add(violation.getMessage());
        }

        return errors;
    }

    @Override
    public void enable() {
        if(price > 0.0){
            throw new PriceException("The price must be greater than zero to enable the product");
        }
        status = Status.ENABLED;
    }

    @Override
    public void disable() {
        if(price == 0.0){
            throw new PriceException("The price must be zero in order to have the product disabled");

        }
        status = Status.DISABLED;

    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
