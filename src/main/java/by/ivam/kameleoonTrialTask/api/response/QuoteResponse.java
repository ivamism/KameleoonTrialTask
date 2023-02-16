package by.ivam.kameleoonTrialTask.api.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QuoteResponse {
    private long id;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String userName;
    private int score;
}
