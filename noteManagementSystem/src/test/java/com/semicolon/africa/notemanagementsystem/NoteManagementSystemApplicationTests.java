package com.semicolon.africa.notemanagementsystem;

import com.semicolon.africa.notemanagementsystem.data.repositories.UserRepository;
import com.semicolon.africa.notemanagementsystem.dto.request.RegisterUserRequest;
import com.semicolon.africa.notemanagementsystem.services.UserService;
import com.semicolon.africa.notemanagementsystem.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoteManagementSystemApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testThatUserCanSignUp() {
        UserService userService = new UserServiceImpl();
        
    }

}
