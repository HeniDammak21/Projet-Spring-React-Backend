package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ChangeRequest;
import com.example.demo.model.Changes;
import com.example.demo.model.Product;
import com.example.demo.repository.ChangeRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ChangeServiceImpl implements ChangeService {

    @Autowired
    private ChangeRepository changeRepository;
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Changes saveChange(ChangeRequest change)
	{		
    	Changes c = new Changes();
    	if(change.getId() != 0) {
    		c.setId(change.getId());
    	}
    	
    	c.setType(change.getType());
    	c.setNb(change.getNb());
    	c.setUnit_cost(change.getUnit_cost());
    	c.setUnit_price(change.getUnit_price());
    	Optional<Product> p = productRepository.findById(change.getProduct());
    	if(p.isPresent()) {
    		c.setProduct(p.get());	
    	}
        return changeRepository.save(c);
	}
    @Override
    public List<Changes> getAllChanges() {
        return changeRepository.findAll();
    }
    
    @Override
    public void deleteChange(int id) {
    	changeRepository.deleteById(id);
    }
    
    @Override
    public boolean changeExists(int id) {
    	return changeRepository.existsById(id);
    }
    
    @Override
    public Optional<Changes> findChange(int id) {
    	return changeRepository.findById(id);
    }
}
