package com.vipusa.product_service.service;

import com.vipusa.product_service.entity.Product;
import com.vipusa.product_service.repository.ProductRepository;
import com.vipusa.product_service.request.CreateProductRequest;
import com.vipusa.product_service.request.UpdateProductRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CREATE
    @Override
    public Product createProduct(CreateProductRequest request) {
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        return productRepository.save(product);
    }

    // READ (by ID)
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    // READ (all)
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // UPDATE
    @Override
    public Product updateProduct(Long id, UpdateProductRequest request) {
        Product product = getProductById(id);

        if (request.getProductName() != null) {
            product.setProductName(request.getProductName());
        }

        if (request.getDescription() != null) {
            product.setDescription(request.getDescription());
        }

        if (request.getPrice() != null) {
            product.setPrice(request.getPrice());
        }

        return productRepository.save(product);
    }

    // DELETE
    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}