package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    @Override
    public void deleteCategory(int id) {
    	categoryRepository.deleteById(id);
    }
    
    @Override
    public boolean categoryExists(int id) {
    	return categoryRepository.existsById(id);
    }
    
    @Override
    public Optional<Category> findCategory(int id) {
    	return categoryRepository.findById(id);
    }
}
