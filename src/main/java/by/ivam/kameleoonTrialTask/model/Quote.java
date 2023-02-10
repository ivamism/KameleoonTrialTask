package by.ivam.kameleoonTrialTask.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@Entity
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;
    private LocalDateTime createUpdateDate;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "score_id")
    private Score score;

}
