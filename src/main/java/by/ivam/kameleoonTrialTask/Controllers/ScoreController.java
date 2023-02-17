package by.ivam.kameleoonTrialTask.Controllers;

import by.ivam.kameleoonTrialTask.api.response.ScoreResponse;
import by.ivam.kameleoonTrialTask.service.ScoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
public class ScoreController {

    @Autowired
    private ScoreServiceImpl scoreService;

    @PutMapping("/like/{scoreId}")
    @ResponseStatus(HttpStatus.OK)
    public ScoreResponse like(@PathVariable long scoreId) {
        return scoreService.like(scoreId);
    }

    @PutMapping("/dislike/{scoreId}")
    @ResponseStatus(HttpStatus.OK)
    public ScoreResponse disLike(@PathVariable long scoreId) {
        return scoreService.disLike(scoreId);
    }

    @GetMapping("/score/{scoreId}")
    @ResponseStatus(HttpStatus.OK)
    public ScoreResponse getScore(@PathVariable long scoreId) {
        return scoreService.findById(scoreId);
    }
}
