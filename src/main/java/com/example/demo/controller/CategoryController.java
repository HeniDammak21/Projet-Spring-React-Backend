package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

import exception.CategoryNotFoundException;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
	@Autowired
    private CategoryService categoryService;


    @PostMapping("/add")
    public String add(@RequestBody Category category){
        categoryService.saveCategory(category);
        return "New category is added";
    }

    @GetMapping("/getAll")
    public List<Category> list(){
        return categoryService.getAllCategories();
    }
    
    @DeleteMapping("/delete/{id}")
    String deleteCategory(@PathVariable int id) {
    	if(!categoryService.categoryExists(id)) {
    		throw new CategoryNotFoundException(id);
    	}
    	categoryService.deleteCategory(id);
    	return "Category with id "+id+"has been deleted success.";
    }
    
    @PutMapping("/update/{id}")
    Category updateCategory(@RequestBody Category newCategory, @PathVariable int id) {
        return categoryService.findCategory(id)
                .map(category -> {
                    category.setName(newCategory.getName());
                    return categoryService.saveCategory(category);
                }).orElseThrow(() -> new CategoryNotFoundException(id));
    }
}
