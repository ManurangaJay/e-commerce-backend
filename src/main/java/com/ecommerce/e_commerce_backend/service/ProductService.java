package com.ecommerce.e_commerce_backend.service;

import com.ecommerce.e_commerce_backend.model.Product;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final String PRODUCT_FILE_PATH = "src/main/resources/products.json";

    public List<Product> getFilteredProducts(String type, int page, int size) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> allProducts = objectMapper.readValue(new File(PRODUCT_FILE_PATH), new TypeReference<List<Product>>() {});

        List<Product> filteredProducts;

        switch (type.toLowerCase()) {
            case "featured":
                filteredProducts = allProducts;
                break;
            case "best-selling":
                filteredProducts = allProducts.stream()
                        .filter(product -> product.getReviewsCount() > 300)
                        .collect(Collectors.toList());
                break;
            case "todays-deals":
                filteredProducts = allProducts.stream()
                        .filter(product -> product.getDiscountedPrice() > 0)
                        .collect(Collectors.toList());
                break;
            default:
                throw new IllegalArgumentException("Invalid product type: " + type);
        }

        int startIndex = page * size;
        int endIndex = Math.min(startIndex + size, filteredProducts.size());

        return filteredProducts.subList(startIndex, endIndex);
    }
}
