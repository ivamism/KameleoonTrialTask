package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.request.UserCreateRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceInterface {
void  create(UserCreateRequest userRequest);
}
