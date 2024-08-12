package com.semicolon.africa.services;



import com.semicolon.africa.data.models.User;
import com.semicolon.africa.dtos.request.LoginUserRequest;
import com.semicolon.africa.dtos.request.LogoutUserRequest;
import com.semicolon.africa.dtos.request.RegisterUserRequest;
import com.semicolon.africa.dtos.response.LoginUserResponse;
import com.semicolon.africa.dtos.response.LogoutUserResponse;
import com.semicolon.africa.dtos.response.RegisterUserResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);

    LoginUserResponse login(LoginUserRequest loginUserRequest);

    LogoutUserResponse logout(LogoutUserRequest logoutUserRequest);

    List<User> getAllUser();

//    List<User> getAllUser();


}
