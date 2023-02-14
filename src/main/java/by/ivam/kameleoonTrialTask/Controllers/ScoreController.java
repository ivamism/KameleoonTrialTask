package by.ivam.kameleoonTrialTask.Controllers;

import by.ivam.kameleoonTrialTask.api.response.ScoreResponse;
import by.ivam.kameleoonTrialTask.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PutMapping("/like/{id}")
    public ResponseEntity<?> like(@PathVariable long id) {
        scoreService.like(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/dislike/{id}")
    public ResponseEntity<?> disLike(@PathVariable long id) {
        scoreService.disLike(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/score/{id}")
    public ResponseEntity<?> getScore(@PathVariable long id) {
        ScoreResponse scoreResponse = scoreService.getScoreById(id);

        return new ResponseEntity<>(scoreResponse,HttpStatus.OK);
    }

}
