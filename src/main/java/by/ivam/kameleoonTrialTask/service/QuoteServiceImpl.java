package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.request.QuoteCreateRequest;
import by.ivam.kameleoonTrialTask.api.request.UpdateQuoteRequest;
import by.ivam.kameleoonTrialTask.api.response.QuoteResponse;
import by.ivam.kameleoonTrialTask.api.response.UserResponse;
import by.ivam.kameleoonTrialTask.exceptions.QuoteNotFoundException;
import by.ivam.kameleoonTrialTask.model.Quote;
import by.ivam.kameleoonTrialTask.model.Score;
import by.ivam.kameleoonTrialTask.model.User;
import by.ivam.kameleoonTrialTask.repositories.QuoteRepository;
import by.ivam.kameleoonTrialTask.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuoteServiceImpl implements QuoteService {
    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScoreServiceImpl scoreService;

    @Autowired
    UserServiceImpl userService;

    @Override
    public QuoteResponse findById(long id) {
        Quote quote = quoteRepository.findById(id).orElseThrow(()
                -> new QuoteNotFoundException("The Quote not found"));
        return quoteResponseCreator(quote);
    }

    @Override
    public QuoteResponse getRandomQuote() {
        Quote quote;
        if (quoteRepository.countQuotesQuantity() == 0) {
            throw new QuoteNotFoundException("No any quotes to display");
        } else {
            while (true) {
                Random rndIdGen = new Random();
                long randomId = rndIdGen.nextInt(quoteRepository.lastUsedId());
                Optional<Quote> optionalQuote = quoteRepository.findById(randomId);
                if (optionalQuote.isPresent()) {
                    quote = optionalQuote.get();
                    break;
                }
            }
        }
        return quoteResponseCreator(quote);
    }

    @Override
    public QuoteResponse create(QuoteCreateRequest quoteCreateRequest) {
        Quote quote = new Quote();
        quote.setContent(quoteCreateRequest.getContent());
        quote.setUser(userRepository.findById(quoteCreateRequest.getUserId()).get());
        quote.setCreationDate(LocalDateTime.now());
        quote.setModificationDate(LocalDateTime.now());
        quote.setScore(scoreService.create());
        quoteRepository.save(quote);
        return quoteResponseCreator(quote);
    }

    @Override
    public QuoteResponse update(long id, UpdateQuoteRequest updateQuote) {

        Quote quote = quoteRepository.findById(id).orElseThrow(()
                -> new QuoteNotFoundException("The Quote not found"));
        quote.setContent(updateQuote.getContent());
        quote.setModificationDate(LocalDateTime.now());
        quoteRepository.save(quote);
        return quoteResponseCreator(quote);
    }

    @Override
    public void delete(long id) {
        if (quoteRepository.findById(id).isPresent()) {
            quoteRepository.deleteById(id);
        } else {
            throw new QuoteNotFoundException("The Quote not found");
        }
    }

    @Override
    public List<QuoteResponse> find10top() {
        return quoteRepository.findTop10AllByOrderByScore_ScoreDesc()
                .stream()
                .map(quote -> quoteResponseCreator(quote))
                .collect(Collectors.toList());
    }

    @Override
    public List<QuoteResponse> find10flop() {
        return quoteRepository.findTop10AllByOrderByScore_ScoreAsc()
                .stream()
                .map(quote -> quoteResponseCreator(quote))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findQuoteOwner(long id) {
        Quote quote = quoteRepository.findById(id)
                .orElseThrow(() -> new QuoteNotFoundException("The Quote not found"));
        User quoteOwner = quote.getUser();
        return userService.userResponseCreator(quoteOwner);
    }

    @Override
    public Score getQuoterScore(long id) {
        Quote quote = quoteRepository.findById(id)
                .orElseThrow(() -> new QuoteNotFoundException("The Quote not found"));
        return quote.getScore();
    }

    private QuoteResponse quoteResponseCreator(Quote quote) {
        QuoteResponse quoteResponse = new QuoteResponse();
        quoteResponse.setId(quote.getId());
        quoteResponse.setContent(quote.getContent());
        quoteResponse.setCreateDate(quote.getCreationDate());
        quoteResponse.setUpdateDate(quote.getModificationDate());
        quoteResponse.setUserName(quote.getUser().getName());
        quoteResponse.setScore(quote.getScore().getScore());
        return quoteResponse;
    }
}
