package com.semicolon.africa.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
}

