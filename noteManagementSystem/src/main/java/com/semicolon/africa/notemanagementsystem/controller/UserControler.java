package com.semicolon.africa.notemanagementsystem.controller;

import com.semicolon.africa.notemanagementsystem.dto.request.LoginUserRequest;
import com.semicolon.africa.notemanagementsystem.dto.request.RegisterUserRequest;
import com.semicolon.africa.notemanagementsystem.dto.response.LoginUserResponse;
import com.semicolon.africa.notemanagementsystem.dto.response.RegisterUserResponse;
import com.semicolon.africa.notemanagementsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserControler {

    @Autowired
    private UserService userService;


    @PostMapping("/v1/UserLogin")
    public ResponseEntity<?> userLogin(@RequestBody LoginUserRequest loginUserRequest){
        try {
            LoginUserResponse response = userService.loginUser(loginUserRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/RegisterUser")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest registerUserRequest){
        try {
            RegisterUserResponse response = userService.registerUser(registerUserRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }














}
