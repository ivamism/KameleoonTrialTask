package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.request.QuoteCreateRequest;
import by.ivam.kameleoonTrialTask.api.request.QuoteRequest;
import by.ivam.kameleoonTrialTask.api.response.QuoteResponse;
import by.ivam.kameleoonTrialTask.model.Quote;
import by.ivam.kameleoonTrialTask.model.Score;
import by.ivam.kameleoonTrialTask.repositories.QuoteRepository;
import by.ivam.kameleoonTrialTask.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QuoteService implements QuoteServiceInterface {
    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScoreService scoreService;

    @Override
    public QuoteResponse findById(long id) {
        Quote quote = quoteRepository.findById(id).get();
        QuoteResponse quoteResponse = new QuoteResponse();
        quoteResponse.setContent(quote.getContent());
        quoteResponse.setCreateDate(quote.getCreateDate());
        quoteResponse.setUpdateDate(quote.getUpdateDate());
        quoteResponse.setUserName(quote.getUser().getName());
        quoteResponse.setScore(quote.getScore().getScore());
        return quoteResponse;
    }

    @Override
    public QuoteResponse create(QuoteCreateRequest quoteCreateRequest) {
        Quote quote = new Quote();
        quote.setContent(quoteCreateRequest.getContent());
        quote.setUser(userRepository.findById(quoteCreateRequest.getUserId()).get());
        quote.setCreateDate(LocalDateTime.now());
        quote.setUpdateDate(LocalDateTime.now());
        quote.setScore(scoreService.create());
        quoteRepository.save(quote);
        QuoteResponse quoteResponse = new QuoteResponse();
        quoteResponse.setId(quote.getId());
        quoteResponse.setContent(quote.getContent());
        quoteResponse.setCreateDate(quote.getCreateDate());
        quoteResponse.setUpdateDate(quote.getUpdateDate());
        quoteResponse.setUserId(quote.getUser().getId());
        quoteResponse.setUserName(quote.getUser().getName());
        quoteResponse.setScore(quote.getScore().getScore());
        return quoteResponse;
    }

    @Override
    public QuoteResponse update(long id, QuoteRequest quoteRequest) {
        Quote quote = quoteRepository.findById(id).get();
        quote.setContent(quoteRequest.getContent());
        quote.setUpdateDate(LocalDateTime.now());
        quoteRepository.save(quote);
        return quoteResponseCreator(quote);
    }
    private QuoteResponse quoteResponseCreator(Quote quote){
        QuoteResponse quoteResponse = new QuoteResponse();
        quoteResponse.setId(quote.getId());
        quoteResponse.setContent(quote.getContent());
        quoteResponse.setCreateDate(quote.getCreateDate());
        quoteResponse.setUpdateDate(quote.getUpdateDate());
        quoteResponse.setUserId(quote.getUser().getId());
        quoteResponse.setUserName(quote.getUser().getName());
        quoteResponse.setScore(quote.getScore().getScore());
        return quoteResponse;
    }


}
