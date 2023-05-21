package com.example.fooddeliveryplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpInput {
    
    private String firstName;
    private String lastname;
    private int age;
    private String email;
    private String phoneNumber;
    private String password;
}
