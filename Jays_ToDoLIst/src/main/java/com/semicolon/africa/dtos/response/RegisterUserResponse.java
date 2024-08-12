package com.semicolon.africa.dtos.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class RegisterUserResponse {
    private String userId;
    private String message;


}

