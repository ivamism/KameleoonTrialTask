package by.ivam.kameleoonTrialTask.service;

import by.ivam.kameleoonTrialTask.api.response.QuoteResponse;
import by.ivam.kameleoonTrialTask.exceptions.QuoteNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class QuoteServiceImplTest {
    @Autowired
    QuoteServiceImpl quoteService;

//    @MockBean
//    private QuoteRepository quoteRepositoryTest;


    @Test
    void find10top() {
        List<QuoteResponse> top10 = quoteService.find10top();
        assertNotNull(top10);
    }

//    @Test
//    void countQuotesQuantity() {
//        int actual = quoteService.countQuotesQuantity();
//        int expected = 23;
//        assertEquals(expected, actual);
//    }

    @Test
    void delete() {
        QuoteNotFoundException exception = assertThrows(QuoteNotFoundException.class, () -> {
            quoteService.delete(150);});

        assertEquals("The Quote not found", exception.getMessage());
    }

//    @Test
//    void getRandomQuote() {
//        QuoteNotFoundException exception = assertThrows(QuoteNotFoundException.class, () -> {
//            quoteRepositoryTest.countQuotesQuantity();});
//
//        assertEquals("No any quotes to display", exception.getMessage());
//    }

}