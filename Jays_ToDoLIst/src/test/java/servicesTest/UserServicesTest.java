package servicesTest;

import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.request.AddTaskRequest;
import com.semicolon.africa.dtos.request.RegisterUserRequest;
import com.semicolon.africa.dtos.response.RegisterUserResponse;
import com.semicolon.africa.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserServicesTest {
    @Autowired
    UserService userService;

    @Test
    public void testThatNewUser_CanRegister(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setFirstName("josh");
        request.setLastName("Bill");
        request.setEmail("bill@Josh");
        request.setPassword("Joshh");
        UserRepository userRepository = new
    }


}
