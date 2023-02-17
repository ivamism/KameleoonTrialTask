package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.request.UserCreateRequest;
import by.ivam.kameleoonTrialTask.api.response.UserResponse;
import by.ivam.kameleoonTrialTask.model.User;
import by.ivam.kameleoonTrialTask.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Data
public class UserServiceImpl implements UserServiceInterface {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse create(UserCreateRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setCreationDate(LocalDateTime.now());
        userRepository.save(user);
        return userResponseCreator(user);
    }

    UserResponse userResponseCreator(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setCreationDate(user.getCreationDate());
        return userResponse;
    }
}
