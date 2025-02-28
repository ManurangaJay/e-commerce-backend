package com.ecommerce.e_commerce_backend.controller;

import com.ecommerce.e_commerce_backend.model.Product;
import com.ecommerce.e_commerce_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{type}")
    public List<Product> getProducts(
            @PathVariable String type,
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) throws IOException {
        return productService.getFilteredProducts(type, page, size);
    }
}