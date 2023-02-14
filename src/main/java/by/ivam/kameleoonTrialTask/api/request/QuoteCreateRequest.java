package by.ivam.kameleoonTrialTask.api.request;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class QuoteCreateRequest {

    private String content;

    private long userId;

}
