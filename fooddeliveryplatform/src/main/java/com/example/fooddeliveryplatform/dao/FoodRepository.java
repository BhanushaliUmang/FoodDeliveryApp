package com.example.fooddeliveryplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fooddeliveryplatform.model.FoodItem;

@Repository
public interface FoodRepository extends JpaRepository<FoodItem,Long>{
    
}
