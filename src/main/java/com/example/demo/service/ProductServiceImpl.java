package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product saveProduct(ProductRequest product)
	{		
    	Product p = new Product();
    	if(product.getId() != 0) {
    		p.setId(product.getId());
    	}
    	
    	p.setName(product.getName());
    	p.setBrand(product.getBrand());
    	p.setDescription(product.getDescription());
    	p.setOriginal_price(product.getOriginal_price());
    	p.setSelling_price(product.getSelling_price());
    	p.setQty(product.getQty());
    	p.setImage(product.getImage());
    	p.setCost(product.getCost());
    	p.setTo_buy(product.isTo_buy());
    	Optional<Category> c = categoryRepository.findById(product.getCategory());
    	if(c.isPresent()) {
    		p.setCategory(c.get());	
    	}
        return productRepository.save(p);
	}

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @Override
    public List<Product> getOutOfStock() {
        return productRepository.findByQtyLessThan(10);
    }
    
    @Override
    public void deleteProduct(int id) {
    	productRepository.deleteById(id);
    }
    
    @Override
    public boolean productExists(int id) {
    	return productRepository.existsById(id);
    }
    
    @Override
    public Optional<Product> findProduct(int id) {
    	return productRepository.findById(id);
    }
}
