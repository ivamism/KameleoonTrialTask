package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.request.QuoteCreateRequest;
import by.ivam.kameleoonTrialTask.api.request.QuoteRequest;
import by.ivam.kameleoonTrialTask.api.response.QuoteResponse;

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
}
