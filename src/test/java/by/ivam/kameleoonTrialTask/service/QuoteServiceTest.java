package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.response.QuoteResponse;
import by.ivam.kameleoonTrialTask.model.Quote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class QuoteServiceTest {
    @Autowired
    QuoteService quoteService;

    @Test
    void find10top() {
        List<QuoteResponse> top10 = quoteService.find10top();
        assertNotNull(top10);
    }
}