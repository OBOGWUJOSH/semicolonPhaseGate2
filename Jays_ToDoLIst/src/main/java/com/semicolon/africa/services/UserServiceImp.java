package com.semicolon.africa.services;


import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.request.LoginUserRequest;
import com.semicolon.africa.dtos.request.LogoutUserRequest;
import com.semicolon.africa.dtos.request.RegisterUserRequest;
import com.semicolon.africa.dtos.response.LoginUserResponse;
import com.semicolon.africa.dtos.response.LogoutUserResponse;
import com.semicolon.africa.dtos.response.RegisterUserResponse;
import com.semicolon.africa.utilities.TodoAppException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.semicolon.africa.utilities.Validators.registeredUserValidation;


@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        registeredUserValidation(registerUserRequest);
        String firstName = registerUserRequest.getFirstName();
        String lastname = registerUserRequest.getLastName();
        String password = registerUserRequest.getPassword();
        String email = registerUserRequest.getEmail().toLowerCase().trim();
        User user = userMapper(firstName,lastname, password, email);
        userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setUserId(user.getId());
        response.setMessage("Registration successful");
        return response;
    }


//    public void sendRegistrationEmail(String email) {
//        JavaMailRequest javaMailRequest = new JavaMailRequest();
//        javaMailRequest.setTo(email);
//        javaMailRequest.setMessage("Welcome to my todoApp");
//        javaMailRequest.setSubject("TodoApp Verification");
//        javaMailRequest.setFrom(mailConfig.getFromEmail());
//        mailService.send(javaMailRequest);
//    }



    @Override
    public LoginUserResponse login(LoginUserRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername().toLowerCase());
        if (user == null || !checkPassword(loginRequest.getPassword())) {
            throw new TodoAppException("Invalid username or password");
        }

        user.setLoggedIn(true);
        userRepository.save(user);

        return new LoginUserResponse("Successful Login");
    }

    private boolean checkPassword(String password) {
        if (password.length() > 8) {
        }
        return true;
    }

    @Override
    public LogoutUserResponse logout(LogoutUserRequest logoutUserRequest) {
        User user = userRepository.findByUsername(logoutUserRequest.getUsername().toLowerCase());
        if (user == null) {
            throw new TodoAppException("User not found");
        }

        user.setLoggedIn(false);
        userRepository.save(user);

        return new LogoutUserResponse("Successful Logout");
    }



    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    private static User userMapper(String userName, String password, String email, String s) {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setLoggedIn(false);
        return user;
    }
}
