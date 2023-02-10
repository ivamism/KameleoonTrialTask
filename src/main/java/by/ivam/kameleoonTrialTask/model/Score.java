package by.ivam.kameleoonTrialTask.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    int goodVotes;
    private int badVotes;
    private int score;
}
