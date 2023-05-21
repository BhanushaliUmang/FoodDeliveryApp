package com.example.fooddeliveryplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddeliveryplatform.model.AuthenticationToken;
import com.example.fooddeliveryplatform.model.User;

public interface TokenRepo extends JpaRepository<AuthenticationToken,Long>{
    

    AuthenticationToken findByUser(User user);

    AuthenticationToken findFirstByToken(String token);
}
