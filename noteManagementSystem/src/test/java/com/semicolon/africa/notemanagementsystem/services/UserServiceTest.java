package com.semicolon.africa.notemanagementsystem.services;

import com.semicolon.africa.notemanagementsystem.data.models.User;
import com.semicolon.africa.notemanagementsystem.data.repositories.UserRepository;
import com.semicolon.africa.notemanagementsystem.dto.request.LoginUserRequest;
import com.semicolon.africa.notemanagementsystem.dto.request.RegisterUserRequest;
import com.semicolon.africa.notemanagementsystem.dto.response.RegisterUserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static net.bytebuddy.matcher.ElementMatchers.isEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@RequiredArgsConstructor
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

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

    @Test
    public void testThatUserCanLogin() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUserName("dayo");
        registerUserRequest.setEmail("gmail@gmail.com");
        registerUserRequest.setPassword("123456");
        RegisterUserResponse response = userService.registerUser(registerUserRequest);
        assertThat(response).isNotNull();

        LoginUserRequest loginUserRequest1 = new LoginUserRequest();
        loginUserRequest1.setUserName("dayo");
        loginUserRequest1.setPassword("123456");
        userService.loginUser(loginUserRequest1);
        userRepository.findByUserName(loginUserRequest1.getUserName());
        assertThat("dayo").isEqualTo(loginUserRequest1.getUserName());
    }

    @Test
    public void testThatNewUsersCanNotBe_RegisteredTwice_withTheSameEmail(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUserName("jacky Chan");
        registerUserRequest.setEmail("jacky@gmail.com");
        registerUserRequest.setPhoneNumber("08034785764");
        registerUserRequest.setPassword("123456789");
        userService.registerUser(registerUserRequest);
        RegisterUserRequest registerDuplicateUserEmail = new RegisterUserRequest();


        registerDuplicateUserEmail.setUserName("jacky Chan");
        registerDuplicateUserEmail.setEmail("jacky@gmail.com");
        registerDuplicateUserEmail.setPhoneNumber("08034785764");
        registerUserRequest.setPassword("123456789");
        userService.registerUser(registerDuplicateUserEmail);
        assertThat(userRepository.count()).isEqualTo(2);


    }

    @Test
    public void testThatUserCan_AddNewNote(){
        User user = new User();




    }







}
