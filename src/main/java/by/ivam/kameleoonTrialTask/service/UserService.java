package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.request.UserRequest;
import by.ivam.kameleoonTrialTask.model.User;
import by.ivam.kameleoonTrialTask.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    UserRepository userRepository;

    @Override
    public void create(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setCreationDate(LocalDateTime.now());
        userRepository.save(user);
    }
}
