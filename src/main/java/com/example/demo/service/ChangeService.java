package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.ChangeRequest;
import com.example.demo.model.Changes;

public interface ChangeService {
    public Changes saveChange(ChangeRequest change);
    public List<Changes> getAllChanges();
    public boolean changeExists(int id);
    public void deleteChange(int id);
    public Optional<Changes> findChange(int id);
}
