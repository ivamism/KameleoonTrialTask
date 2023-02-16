package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.response.ScoreResponse;
import by.ivam.kameleoonTrialTask.model.Score;

public interface ScoreServiceInterface {

    ScoreResponse findById(long id);

    Score create();

    ScoreResponse like(long id);

    ScoreResponse disLike(long id);

}
