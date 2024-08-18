package servicesTest;

import com.semicolon.africa.dtos.request.RegisterUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserServicesTest {

    @Test
    public void testThatNewUser_CanRegister(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setFirstName("josh");
        request.setLastName("Bill");
        request.setEmail("bill@Josh");
        request.setPassword("Joshh");


    }


}
