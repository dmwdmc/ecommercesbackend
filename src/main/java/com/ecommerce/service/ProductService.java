package com.ecommerce.service;

import com.ecommerce.dao.ProductRepository;
import com.ecommerce.entity.Product;
import com.ecommerce.wrapper.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product saveProduct(ProductRequest request) {
        Product product=new Product(request.getName(),request.getPrice(),request.getInventory());
        return productRepo.save(product);
    }

}
