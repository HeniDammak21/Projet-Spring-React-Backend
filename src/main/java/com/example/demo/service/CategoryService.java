package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Category;

public interface CategoryService {
    public Category saveCategory(Category category);
    public List<Category> getAllCategories();
    public boolean categoryExists(int id);
    public void deleteCategory(int id);
    public Optional<Category> findCategory(int id);
}
