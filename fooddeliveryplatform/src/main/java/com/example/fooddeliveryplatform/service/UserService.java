package com.example.fooddeliveryplatform.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddeliveryplatform.dao.UserRepository;
import com.example.fooddeliveryplatform.dto.SignInInput;
import com.example.fooddeliveryplatform.dto.SignInOutput;
import com.example.fooddeliveryplatform.dto.SignUpInput;
import com.example.fooddeliveryplatform.dto.SignUpOutput;
import com.example.fooddeliveryplatform.model.AuthenticationToken;
import com.example.fooddeliveryplatform.model.User;

import jakarta.validation.Valid;
import jakarta.xml.bind.DatatypeConverter;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService tokenService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public SignUpOutput signUp(SignUpInput signUpDto) {
        

        // check if user exists or not based on email
        User user = userRepository.findFirstByEmail(signUpDto.getEmail());

        if(user != null)
        {
            throw new IllegalStateException("Patient already exists!!!!...sign in instead");
        }


        //encryption
        // String encryptedPassword = null;
        // try {
        //     encryptedPassword = encryptPassword(signUpDto.getPassword());
        // } catch (NoSuchAlgorithmException e) {
        //     e.printStackTrace();

        // }

        //save the user

        user = new User(signUpDto.getFirstName(),  signUpDto.getLastname() ,  signUpDto.getAge(),  signUpDto.getEmail(),  signUpDto.getPhoneNumber(), signUpDto.getPassword());

        userRepository.save(user);

        //token creation and saving

        AuthenticationToken token = new AuthenticationToken(user);

        tokenService.saveToken(token);

        return new SignUpOutput("User registered","User created successfully");

    }

    // private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
    //     MessageDigest md5 = MessageDigest.getInstance("MD5");
        
    //     md5.update(userPassword.getBytes());
    //     byte[] digested =  md5.digest();

    //     String hash = DatatypeConverter.printHexBinary(digested);
    
        
    //     return hash;
        
        
    // }


    public SignInOutput signIn(SignInInput signInDto) {

        //get email

        User user = userRepository.findFirstByEmail(signInDto.getEmail());

        if(user == null)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        //encrypt the password

        // String encryptedPassword = null;

        // try {
        //     encryptedPassword = encryptPassword(signInDto.getEmail());
        // }
        // catch (NoSuchAlgorithmException e) {
        //     e.printStackTrace();

        // }



        //match it with database encrypted password

        // boolean isPasswordValid = encryptedPassword.equals(user.getPassword());

        // if(!isPasswordValid)
        // {
        //     throw new IllegalStateException("User invalid!!!!...sign up instead");
        // }

        //figure out the token

        AuthenticationToken authToken = tokenService.getToken(user);

        //set up output response

        return new SignInOutput("Authentication Successfull !!!",authToken.getToken());


    }

   
    
}
