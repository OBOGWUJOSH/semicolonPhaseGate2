package com.semicolon.africa.notemanagementsystem.services;

import com.semicolon.africa.notemanagementsystem.dto.request.RegisterUserRequest;
import com.semicolon.africa.notemanagementsystem.dto.response.RegisterUserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@RequiredArgsConstructor
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void testThatUserCanRegister(){
                RegisterUserRequest registerUserRequest = new RegisterUserRequest();
                registerUserRequest.setUserName("jack");
                registerUserRequest.setEmail("j@gmail.com");
                registerUserRequest.setPhoneNumber("08034785764");
                registerUserRequest.setPassword("12344");
                RegisterUserResponse registerUserResponse = userService.registerUser(registerUserRequest);
                assertThat(registerUserResponse).isNotNull();
            }

    }
