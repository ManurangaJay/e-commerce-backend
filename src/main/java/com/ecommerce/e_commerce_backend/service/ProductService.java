package com.ecommerce.e_commerce_backend.service;

import com.ecommerce.e_commerce_backend.model.Product;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    private static final String PRODUCT_FILE_PATH = "src/main/resources/products.json";

    public List<Product> getAllProducts() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(PRODUCT_FILE_PATH), new TypeReference<List<Product>>() {});
    }
}
