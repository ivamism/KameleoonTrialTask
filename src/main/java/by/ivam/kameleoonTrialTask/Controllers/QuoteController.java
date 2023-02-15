package by.ivam.kameleoonTrialTask.Controllers;

import by.ivam.kameleoonTrialTask.api.request.QuoteCreateRequest;
import by.ivam.kameleoonTrialTask.api.request.QuoteRequest;
import by.ivam.kameleoonTrialTask.api.response.QuoteResponse;
import by.ivam.kameleoonTrialTask.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

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
    public QuoteResponse update(@PathVariable long id, @RequestBody QuoteRequest quoteRequest) {

        return quoteService.update(id, quoteRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        quoteService.delete(id);
    }

    @GetMapping("/10top")
    @ResponseStatus(HttpStatus.OK)
    public List<QuoteResponse> getTop10() {
        return quoteService.find10top();
    }
@GetMapping("/10flop")
    @ResponseStatus(HttpStatus.OK)
    public List<QuoteResponse> getFlop10() {
        return quoteService.find10flop();
    }

}
