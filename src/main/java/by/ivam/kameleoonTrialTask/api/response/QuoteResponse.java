package by.ivam.kameleoonTrialTask.api.response;

import by.ivam.kameleoonTrialTask.model.Score;
import by.ivam.kameleoonTrialTask.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
public class QuoteResponse {
    private long id;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private long userId;
    private String userName;
    private long scoreId;
    private int score;
}
