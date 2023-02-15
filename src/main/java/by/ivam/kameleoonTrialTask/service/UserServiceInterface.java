package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.request.UserCreateRequest;
import by.ivam.kameleoonTrialTask.api.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceInterface {
    UserResponse create(UserCreateRequest userRequest);
}
