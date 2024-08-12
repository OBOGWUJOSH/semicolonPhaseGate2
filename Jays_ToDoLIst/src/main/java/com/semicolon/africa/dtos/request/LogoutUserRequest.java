package com.semicolon.africa.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class LogoutUserRequest {
    private String username;
    private String password;


}
