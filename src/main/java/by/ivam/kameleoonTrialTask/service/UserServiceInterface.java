package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.request.UserRequest;
import by.ivam.kameleoonTrialTask.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceInterface {
void  create(UserRequest userRequest);
}
