package com.example.exception_test.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;


    @NotBlank(message = "username should not be blank")
    private String userName;

    @NotBlank(message = "password should not be blank")
    private String password;

    @NotBlank(message = "name should not be blank")
    private String name;

    @Email(message = "Invalid Email Address")
    private String email;

    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
    private String mobile;

    @NotBlank(message = "Gender should not be blank")
    private String gender;

    @Min(18)
    @Max(60)
    private int age;


    @NotBlank(message = "Nationality should not be blank")
    private String nationality;
}
