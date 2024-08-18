package com.semicolon.africa.notemanagementsystem.services;

import com.semicolon.africa.notemanagementsystem.dto.request.LoginUserRequest;
import com.semicolon.africa.notemanagementsystem.dto.request.LogoutUserRequest;
import com.semicolon.africa.notemanagementsystem.dto.request.RegisterUserRequest;
import com.semicolon.africa.notemanagementsystem.dto.response.LoginUserResponse;
import com.semicolon.africa.notemanagementsystem.dto.response.RegisterUserResponse;

public interface UserService {

    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);

    LoginUserResponse loginUser(LoginUserRequest loginUserRequest);

    void LogoutUser(LogoutUserRequest logoutUserRequest);

}