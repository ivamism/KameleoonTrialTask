package by.ivam.kameleoonTrialTask.Controllers;

import by.ivam.kameleoonTrialTask.api.response.ScoreResponse;
import by.ivam.kameleoonTrialTask.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PutMapping("/like/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScoreResponse like(@PathVariable long id) {
        return scoreService.like(id);
    }

    @PutMapping("/dislike/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScoreResponse disLike(@PathVariable long id) {
        return scoreService.disLike(id);
    }

    @GetMapping("/score/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScoreResponse getScore(@PathVariable long id) {
        return scoreService.findById(id);
    }
}
