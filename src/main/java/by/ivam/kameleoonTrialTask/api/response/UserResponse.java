package by.ivam.kameleoonTrialTask.api.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private long id;
    private String name;
    private String email;
    private LocalDateTime creationDate;
}
