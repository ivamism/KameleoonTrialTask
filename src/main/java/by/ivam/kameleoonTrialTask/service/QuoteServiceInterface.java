package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.request.QuoteCreateRequest;
import by.ivam.kameleoonTrialTask.api.request.QuoteRequest;
import by.ivam.kameleoonTrialTask.api.response.QuoteResponse;
import by.ivam.kameleoonTrialTask.api.response.ScoreResponse;
import by.ivam.kameleoonTrialTask.model.Quote;
import by.ivam.kameleoonTrialTask.model.Score;

public interface QuoteServiceInterface {

    QuoteResponse findById(long id);

    QuoteResponse create(QuoteCreateRequest quoteCreateRequest);

    QuoteResponse update (long id, QuoteRequest quoteRequest);

    void delete(long id);
}
