package by.ivam.kameleoonTrialTask.Controllers;

import by.ivam.kameleoonTrialTask.api.request.QuoteCreateRequest;
import by.ivam.kameleoonTrialTask.api.request.UpdateQuoteRequest;
import by.ivam.kameleoonTrialTask.api.response.QuoteResponse;
import by.ivam.kameleoonTrialTask.api.response.UserResponse;
import by.ivam.kameleoonTrialTask.model.Score;
import by.ivam.kameleoonTrialTask.service.QuoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    private QuoteServiceImpl quoteService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public QuoteResponse create(@RequestBody QuoteCreateRequest quoteCreateRequest) {
        return quoteService.create(quoteCreateRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public QuoteResponse getById(@PathVariable long id) {
        return quoteService.findById(id);
    }

    @GetMapping("/random")
    @ResponseStatus(HttpStatus.OK)
    public QuoteResponse getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public QuoteResponse update(@PathVariable long id, @RequestBody UpdateQuoteRequest quoteRequest) {
        return quoteService.update(id, quoteRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        quoteService.delete(id);
    }

    @GetMapping("/top10")
    @ResponseStatus(HttpStatus.OK)
    public List<QuoteResponse> getTop10() {
        return quoteService.find10top();
    }

    @GetMapping("/flop10")
    @ResponseStatus(HttpStatus.OK)
    public List<QuoteResponse> getFlop10() {
        return quoteService.find10flop();
    }

    @GetMapping("/quoteOwner/{quoteId}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse findQuoteOwner(@PathVariable long quoteId) {
        return quoteService.findQuoteOwner(quoteId);
    }

    @GetMapping("/quoteScore/{scoreId}")
    @ResponseStatus(HttpStatus.OK)
    public Score getQuoteScore(@PathVariable long scoreId) {
        return quoteService.getQuoterScore(scoreId);
    }

}
