package com.example.fooddeliveryplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddeliveryplatform.dao.TokenRepo;
import com.example.fooddeliveryplatform.model.AuthenticationToken;
import com.example.fooddeliveryplatform.model.User;

@Service
public class AuthenticationService {
    
    @Autowired
    TokenRepo iTokenRepo;

    public void saveToken(AuthenticationToken token)
    {
        iTokenRepo.save(token);
    }

    public AuthenticationToken getToken(User user) {
        return  iTokenRepo.findByUser(user);
 
     }

     public boolean authenticate(String userEmail, String token) {

        AuthenticationToken authToken = iTokenRepo.findFirstByToken(token);//find token object via token string
        String expectedEmail = authToken.getUser().getEmail();
        return expectedEmail.equals(userEmail);

   }
}
