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

import com.example.demo.dto.ChangeRequest;
import com.example.demo.model.Changes;
import com.example.demo.service.ChangeService;

import exception.ChangeNotFoundException;

@RestController
@RequestMapping("/change")
@CrossOrigin
public class ChangeController {
	@Autowired
    private ChangeService changeService;


    @PostMapping("/add")
    public String add(@RequestBody ChangeRequest change){
        changeService.saveChange(change);
        return "New change is added";
    }

    @GetMapping("/getAll")
    public List<Changes> list(){
        return changeService.getAllChanges();
    }
    
    @DeleteMapping("/delete/{id}")
    String deleteChange(@PathVariable int id) {
    	if(!changeService.changeExists(id)) {
    		throw new ChangeNotFoundException(id);
    	}
    	changeService.deleteChange(id);
    	return "Change with id "+id+"has been deleted success.";
    }
    
    @PutMapping("/update/{id}")
    Changes updateCategory(@RequestBody ChangeRequest newChange, @PathVariable int id) {
		final ChangeRequest c2 = newChange;
        return changeService.findChange(id)
                .map(oldChange -> {
                	c2.setId(oldChange.getId());
                    return changeService.saveChange(c2);
                }).orElseThrow(() -> new ChangeNotFoundException(id));
    }
}
