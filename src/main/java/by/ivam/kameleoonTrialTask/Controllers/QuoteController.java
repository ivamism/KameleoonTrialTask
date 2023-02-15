package by.ivam.kameleoonTrialTask.Controllers;

import by.ivam.kameleoonTrialTask.api.request.QuoteCreateRequest;
import by.ivam.kameleoonTrialTask.api.request.QuoteRequest;
import by.ivam.kameleoonTrialTask.api.response.QuoteResponse;
import by.ivam.kameleoonTrialTask.model.Quote;
import by.ivam.kameleoonTrialTask.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    public QuoteResponse getById(@PathVariable long id) {
        return quoteService.findById(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public QuoteResponse update(@PathVariable long id, @RequestBody QuoteRequest quoteRequest) {

        return quoteService.update(id, quoteRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id){
        quoteService.delete(id);
    }
}
