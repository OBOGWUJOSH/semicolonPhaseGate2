package com.semicolon.africa.dtos.request;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
//@Setter
//@Getter
public class LoginUserRequest {
    private String username;
    private String password;

}
