package com.semicolon.africa.notemanagementsystem.services;

import com.semicolon.africa.notemanagementsystem.data.models.User;
import com.semicolon.africa.notemanagementsystem.dto.request.RegisterUserRequest;
import com.semicolon.africa.notemanagementsystem.dto.response.RegisterUserResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setUserName(registerUserRequest.getUserName());
        user.setEmail(registerUserRequest.getEmail());
        user.setPhoneNumber(registerUserRequest.getPhoneNumber());
        user.setPassword(registerUserRequest.getPassword());
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setMessage("Registration Successful");
        return registerUserResponse;
    }




}
