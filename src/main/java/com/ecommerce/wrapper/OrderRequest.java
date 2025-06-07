package com.ecommerce.wrapper;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderRequest {
    @NotNull(message = "Product ID cannot be empty")
    private Long productId;

    @Min(value = 1, message = "quantity must be bigger than 0")
    private Integer quantity;

    public OrderRequest() {}

    public OrderRequest(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getter & Setter
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
