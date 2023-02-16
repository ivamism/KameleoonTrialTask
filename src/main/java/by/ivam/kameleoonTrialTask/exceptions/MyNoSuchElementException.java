package by.ivam.kameleoonTrialTask.exceptions;

import java.util.function.Supplier;

public class MyNoSuchElementException extends RuntimeException{
    public MyNoSuchElementException(String message) {
        super(message);
    }
    public static Supplier<MyNoSuchElementException> myNoSuchElementException(String message) {
        return () -> new MyNoSuchElementException(message);
    }
}
