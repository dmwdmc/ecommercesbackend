package com.ecommerce.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer inventory;

    public Product() {}

    public Product(String name, Double price, Integer inventory) {
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }

    // Getter/Setter
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Integer getInventory() { return inventory; }
    public void setInventory(Integer stock) { this.inventory = stock; }
}

