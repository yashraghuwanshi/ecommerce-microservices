package com.example.service;

import com.example.dto.ProductRequest;
import com.example.dto.ProductResponse;

import java.util.List;

public interface ProductService  {

    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getProducts();
}
