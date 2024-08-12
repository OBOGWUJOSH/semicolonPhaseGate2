package com.semicolon.africa.web;

import com.semicolon.africa.dtos.request.LoginUserRequest;
import com.semicolon.africa.dtos.request.RegisterUserRequest;
import com.semicolon.africa.dtos.response.ApiResponse;
import com.semicolon.africa.dtos.response.LoginUserResponse;
import com.semicolon.africa.dtos.response.RegisterUserResponse;
import com.semicolon.africa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/user")
public class userController {
    @Autowired
    private UserService userService;



    @PostMapping("/register")
    public ResponseEntity<?> signUp(@RequestBody RegisterUserRequest request){
        try{
            RegisterUserResponse response = userService.registerUser(request);
            return new ResponseEntity<>(new ApiResponse(true, response),CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }


    @PostMapping("/signIn")
    public ResponseEntity <?> signIn(@RequestBody LoginUserRequest request){
        try{
            LoginUserResponse response = userService.login(request);
            return new ResponseEntity<>(new ApiResponse(true, response),CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

//    @PostMapping("/")







}
