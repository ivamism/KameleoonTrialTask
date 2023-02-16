package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.request.QuoteCreateRequest;
import by.ivam.kameleoonTrialTask.api.request.QuoteRequest;
import by.ivam.kameleoonTrialTask.api.response.QuoteResponse;
import by.ivam.kameleoonTrialTask.api.response.UserResponse;
import by.ivam.kameleoonTrialTask.model.Score;

import java.util.List;

public interface QuoteServiceInterface {

    QuoteResponse findById(long id);
    QuoteResponse getRandomQuote();

    QuoteResponse create(QuoteCreateRequest quoteCreateRequest);

    QuoteResponse update (long id, QuoteRequest quoteRequest);

    void delete(long id);
    List<QuoteResponse> find10top ();
    List<QuoteResponse> find10flop ();
    int countQuotesQuantity();

    UserResponse findQuoteOwner(long id);

    Score getQuoterScore (long id);
}
