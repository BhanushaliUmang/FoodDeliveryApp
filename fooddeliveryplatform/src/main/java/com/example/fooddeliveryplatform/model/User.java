package com.example.fooddeliveryplatform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    // @NotNull(message = "Name is required")
    private String firstName;

    // @NotNull(message = "Name is required")
    private String lastName;

    // @Min(value = 18, message = "Age must be at least 18")
    private int age;

    // @NotNull(message = "Email is required")
    // @Email(message = "Invalid email format")
    private String email;

    // @NotNull(message = "Phone number is required")
    // @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number format.")
    private String phoneNumber;

    // @NotNull(message = "Password is required")
    // @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$", message = "Invalid password format.")
    private String password;

    public User(String firstName, String lastName, int age, String email, String phoneNumber,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }


}
