package com.example.fooddeliveryplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fooddeliveryplatform.model.Orders;


@Repository
public interface OrderRepository extends JpaRepository<Orders,Long>{
    
}
