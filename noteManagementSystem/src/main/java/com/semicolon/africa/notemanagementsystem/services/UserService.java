package com.semicolon.africa.notemanagementsystem.services;

import com.semicolon.africa.notemanagementsystem.dto.request.RegisterUserRequest;
import com.semicolon.africa.notemanagementsystem.dto.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerUser (RegisterUserRequest registerUserRequest);
}
