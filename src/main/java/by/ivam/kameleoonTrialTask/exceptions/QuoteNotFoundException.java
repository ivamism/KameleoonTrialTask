package by.ivam.kameleoonTrialTask.exceptions;

import java.util.function.Supplier;

public class QuoteNotFoundException extends RuntimeException{
    public QuoteNotFoundException(String message) {
        super(message);
    }
    public static Supplier<QuoteNotFoundException> quoteNotFoundException(String message) {
        return () -> new QuoteNotFoundException(message);
    }
}
