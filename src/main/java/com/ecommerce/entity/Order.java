package com.ecommerce.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double totalPrice;

    public Order() {}

    public Order(Product product, Integer quantity) {
        this.orderId = UUID.randomUUID().toString();
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = product.getPrice() * quantity;
    }

    public String getOrderId() { return orderId; }
    public Product getProduct() { return product; }
    public Integer getQuantity() { return quantity; }
    public Double getTotalPrice() { return totalPrice; }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}