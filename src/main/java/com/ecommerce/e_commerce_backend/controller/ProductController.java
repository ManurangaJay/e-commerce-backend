package com.ecommerce.e_commerce_backend.controller;

import com.ecommerce.e_commerce_backend.model.Product;
import com.ecommerce.e_commerce_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/products")  // Set a base URL for all product-related endpoints
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts() throws IOException {
        return productService.getAllProducts();
    }
}
