package com.example.fooddeliveryplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fooddeliveryplatform.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{
    
}
