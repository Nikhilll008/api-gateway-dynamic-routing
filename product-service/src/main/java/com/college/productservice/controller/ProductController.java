package com.college.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This controller returns sample (hardcoded) product data
// In a real project this data would come from a database
@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Map<String, Object>> getProducts() {

        List<Map<String, Object>> productList = new ArrayList<>();

        Map<String, Object> product1 = new HashMap<>();
        product1.put("id", 101);
        product1.put("name", "Laptop");
        product1.put("price", 55000);

        Map<String, Object> product2 = new HashMap<>();
        product2.put("id", 102);
        product2.put("name", "Mobile Phone");
        product2.put("price", 18000);

        Map<String, Object> product3 = new HashMap<>();
        product3.put("id", 103);
        product3.put("name", "Headphones");
        product3.put("price", 1500);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        return productList;
    }
}
