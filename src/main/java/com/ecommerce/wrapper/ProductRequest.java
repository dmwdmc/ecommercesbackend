package com.ecommerce.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class ProductRequest {

    @NotNull(message = "Product name cannot be empty")
    @JsonProperty("name")
    private String name;

    @PositiveOrZero(message = "price must be positive")
    @JsonProperty("price")
    private Double price;

    @Min(value = 1, message = "inventory must be bigger than 0")
    @JsonProperty("inventory")
    private Integer inventory;

    public ProductRequest() {}

    public ProductRequest(String name, Double price,Integer inventory) {
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

}
