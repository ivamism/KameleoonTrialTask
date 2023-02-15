package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.request.UserCreateRequest;
import by.ivam.kameleoonTrialTask.api.response.UserResponse;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;


    @Test
    void create() {
        UserCreateRequest request = new UserCreateRequest();
        request.setName("Paul");
        request.setEmail("ppp@rtt.com");
        request.setPassword("6fheiufy");
        UserResponse response = userService.create(request);
        assertNotNull(response);
    }
}