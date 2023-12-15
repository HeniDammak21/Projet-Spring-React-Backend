package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Changes;

@Repository
public interface ChangeRepository extends JpaRepository<Changes,Integer>{
}

