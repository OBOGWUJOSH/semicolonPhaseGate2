package com.semicolon.africa.notemanagementsystem.services;

import com.semicolon.africa.notemanagementsystem.data.models.User;
import com.semicolon.africa.notemanagementsystem.data.repositories.UserRepository;
import com.semicolon.africa.notemanagementsystem.dto.request.LoginUserRequest;
import com.semicolon.africa.notemanagementsystem.dto.request.LogoutUserRequest;
import com.semicolon.africa.notemanagementsystem.dto.request.RegisterUserRequest;
import com.semicolon.africa.notemanagementsystem.dto.response.LoginUserResponse;
import com.semicolon.africa.notemanagementsystem.dto.response.RegisterUserResponse;
import com.semicolon.africa.notemanagementsystem.utilities.PasswordCheckException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setUserName(registerUserRequest.getUserName());
        user.setEmail(registerUserRequest.getEmail());
        user.setPhoneNumber(registerUserRequest.getPhoneNumber());
        user.setPassword(registerUserRequest.getPassword());
        userRepository.save(user);
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setMessage("Registration Successful");
        return registerUserResponse;
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest loginUserRequest) {
//        User user = userRepository.findByUserName(loginUserRequest.getUserName().toLowerCase());
//        if (user != null) {
//            checkPassword(loginUserRequest.getPassword());
//        }
//        throw new UserManagementException("Something Wrong With Password (Try Again)");
    checkPassword(loginUserRequest.getPassword());
    User user =  new User();
    user.setUserName(loginUserRequest.getUserName());
    user.setPassword(loginUserRequest.getPassword());
    LoginUserResponse loginUserResponse = new LoginUserResponse();
    loginUserResponse.setMessage("successfully logged in");
    return loginUserResponse;
    }


    @Override
    public void LogoutUser(LogoutUserRequest logoutUserRequest) {

    }


    private void checkPassword(String password) {
        User passwordCheck = userRepository.findUserByPassword(password);
        if (passwordCheck == null){
            throw new PasswordCheckException("please input A password");
        }

    }


}
