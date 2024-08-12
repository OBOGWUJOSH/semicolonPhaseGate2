package com.semicolon.africa.notemanagementsystem.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequest {
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
}
