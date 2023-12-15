package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.dto.ProductRequest;
import com.example.demo.model.Product;

public interface ProductService {
    public Product saveProduct(ProductRequest product);
    public List<Product> getAllProducts();
    public List<Product> getOutOfStock();
    public boolean productExists(int id);
    public void deleteProduct(int id);
    public Optional<Product> findProduct(int id);
}
