package com.ecommerce.controller;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.Product;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.ProductService;
import com.ecommerce.wrapper.OrderRequest;
import com.ecommerce.wrapper.OrderResponse;
import com.ecommerce.wrapper.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProducts(@Valid @RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.saveProduct(request));
    }
    @GetMapping("/orders/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@Valid  @PathVariable String id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    @PostMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderRequest request) {
        OrderResponse response = orderService.createOrder(request);
        return ResponseEntity.ok(response);
    }
}