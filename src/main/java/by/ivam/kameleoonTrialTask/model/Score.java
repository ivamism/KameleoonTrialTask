package by.ivam.kameleoonTrialTask.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int likeVotes;
    private int disLikeVotes;
    private int score;

}
