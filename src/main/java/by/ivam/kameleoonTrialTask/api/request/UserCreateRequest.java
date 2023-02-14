package by.ivam.kameleoonTrialTask.api.request;

import lombok.Data;

@Data
public class UserCreateRequest {
    String name;
    String email;
    String password;
}
