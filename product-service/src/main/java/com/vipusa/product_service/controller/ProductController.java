package com.vipusa.product_service.controller;

import com.vipusa.product_service.entity.Product;
import com.vipusa.product_service.request.CreateProductRequest;
import com.vipusa.product_service.request.UpdateProductRequest;
import com.vipusa.product_service.response.ApiResponse;
import com.vipusa.product_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<Product>> createProduct(@RequestBody CreateProductRequest request) {
        Product product = productService.createProduct(request);

        ApiResponse<Product> response = ApiResponse.<Product>builder()
                .isSuccess(true)
                .message("Created Successfully")
                .response(product)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);

        ApiResponse<Product> response = ApiResponse.<Product>builder()
                .isSuccess(true)
                .message("Fetched Successfully")
                .response(product)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        ApiResponse<List<Product>> response = ApiResponse.<List<Product>>builder()
                .isSuccess(true)
                .message("Fetched All Products Successfully")
                .response(products)
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(
            @PathVariable Long id,
            @RequestBody UpdateProductRequest request) {

        Product updatedProduct = productService.updateProduct(id, request);

        ApiResponse<Product> response = ApiResponse.<Product>builder()
                .isSuccess(true)
                .message("Updated Successfully")
                .response(updatedProduct)
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);

        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .isSuccess(true)
                .message("Deleted Successfully")
                .build();

        return ResponseEntity.ok(response);
    }
}
