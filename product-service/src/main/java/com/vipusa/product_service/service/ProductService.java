package com.vipusa.product_service.service;

import com.vipusa.product_service.entity.Product;
import com.vipusa.product_service.request.CreateProductRequest;
import com.vipusa.product_service.request.UpdateProductRequest;

import java.util.List;

public interface ProductService {
    Product createProduct(CreateProductRequest request);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long id, UpdateProductRequest request);

    void deleteProduct(Long id);
}
