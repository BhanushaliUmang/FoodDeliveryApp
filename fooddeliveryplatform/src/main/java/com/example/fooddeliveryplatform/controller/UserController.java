package com.example.fooddeliveryplatform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddeliveryplatform.dto.SignInInput;
import com.example.fooddeliveryplatform.dto.SignInOutput;
import com.example.fooddeliveryplatform.dto.SignUpInput;
import com.example.fooddeliveryplatform.dto.SignUpOutput;
import com.example.fooddeliveryplatform.model.User;
import com.example.fooddeliveryplatform.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;

    

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getById/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteuserById(@PathVariable Long userId){
        userService.deleteUserById(userId);
        return "user deleted";
    }

    @PostMapping("/signup")
    public SignUpOutput signup(@RequestBody SignUpInput signUpDto)
    {
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInDto)
    {
        return userService.signIn(signInDto);
    }
}
