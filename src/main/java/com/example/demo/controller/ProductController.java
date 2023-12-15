package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductRequest;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import exception.ProductNotFoundException;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
	@Autowired
    private ProductService productService;
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

    @PostMapping("/add")
    public String add(@RequestParam("image") MultipartFile file, @RequestParam("product") String product) throws IOException
    {
    	ObjectMapper objectMapper = new ObjectMapper();
    	ProductRequest p = new ProductRequest();
		try {
			p = objectMapper.readValue(product, ProductRequest.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileName = file.getOriginalFilename().replaceAll("\\s+", "");
		String filePath = Paths.get(uploadDirectory, fileName).toString();

		// Save the file locally
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
		try {
			stream.write(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stream.close();
		p.setImage(fileName);
    	productService.saveProduct(p);
    	return "new Product added";
    }
    
    @GetMapping("/getAll")
    public List<Product> list(){
        return productService.getAllProducts();
    }
    
    @GetMapping("/getOutOfStock")
    public List<Product> outofstock(){
        return productService.getOutOfStock();
    }
    
    @DeleteMapping("/delete/{id}")
    String deleteProduct(@PathVariable int id) {
    	if(!productService.productExists(id)) {
    		throw new ProductNotFoundException(id);
    	}
    	productService.deleteProduct(id);
    	return "Product with id "+id+"has been deleted success.";
    }
    
    @PutMapping("/update/{id}")
    Product updateProduct(@RequestParam(name="image",required=false) MultipartFile file, @RequestParam("product") String product, @PathVariable int id) throws IOException {
    	ObjectMapper objectMapper = new ObjectMapper();
    	ProductRequest p = new ProductRequest();
		try {
			p = objectMapper.readValue(product, ProductRequest.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(file!=null) {
		String fileName = file.getOriginalFilename().replaceAll("\\s+", "");
		String filePath = Paths.get(uploadDirectory, fileName).toString();

		// Save the file locally
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
		try {
			stream.write(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stream.close();
		p.setImage(fileName);
		}
		final ProductRequest p2 = p;
        return productService.findProduct(id)
                .map(oldProduct -> {
                	p2.setId(oldProduct.getId());
                    return productService.saveProduct(p2);
                }).orElseThrow(() -> new ProductNotFoundException(id));
    }

}
