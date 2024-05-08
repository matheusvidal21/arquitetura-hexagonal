package com.hexagonal.arquitetura.application.product;

import com.hexagonal.arquitetura.application.exception.PriceException;
import com.hexagonal.arquitetura.application.util.Status;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashSet;
import java.util.Set;

public class Product implements ProductInterface {

    @NotBlank
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
            return false;
        }

        if(price < 0.0){
            return false;
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
    public void enable() throws PriceException {
        if(price > 0.0){
            status = Status.ENABLED;
        } else {
            throw new PriceException("The price must be greater than zero to enable the product");
        }
    }

    @Override
    public void disable() throws PriceException {
        if(price == 0.0){
            status = Status.DISABLED;
        }else {
            throw new PriceException("The price must be zero in order to have the product disabled");
        }
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

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
