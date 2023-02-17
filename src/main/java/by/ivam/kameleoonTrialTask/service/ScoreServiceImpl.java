package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.response.ScoreResponse;
import by.ivam.kameleoonTrialTask.model.Score;
import by.ivam.kameleoonTrialTask.repositories.ScoreRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public ScoreResponse findById(long id) {
        Score score = scoreRepository.findById(id).get();
        return scoreResponseCreator(score);
    }

    @Override
    public Score create() {
        Score score = new Score();
        scoreRepository.save(score);
        return score;
    }

    // Implementation of upVoting
    @Override
    public ScoreResponse like(long id) {
        Score score = scoreRepository.findById(id).get();
        int goodVotes = score.getLikeVotes() + 1;
        int badVotes = score.getDisLikeVotes();
        score.setLikeVotes(goodVotes);
        score.setScore(scoreCalculator(goodVotes, badVotes));
        scoreRepository.save(score);
        return scoreResponseCreator(score);
            }

    // Implementation of downVoting
    @Override
    public ScoreResponse disLike(long id) {
        Score score = scoreRepository.findById(id).get();
        int goodVotes = score.getLikeVotes();
        int badVotes = score.getDisLikeVotes() +1;
        score.setDisLikeVotes(badVotes);
        score.setScore(scoreCalculator(goodVotes, badVotes));
        scoreRepository.save(score);
        return scoreResponseCreator(score);
       }


    ScoreResponse scoreResponseCreator(Score score){
        ScoreResponse scoreResponse = new ScoreResponse();
        scoreResponse.setId(score.getId());
        scoreResponse.setScore(score.getScore());
        return scoreResponse;
    }

    // Calculator of total score
    private int scoreCalculator(int goodVotes, int badVotes) {
        return goodVotes - badVotes;
    }
}
