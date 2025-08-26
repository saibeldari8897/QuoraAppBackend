package org.example.quora.ExceptionHandler;

public class NoAnswersFoundException extends RuntimeException {
    public NoAnswersFoundException(String message) {
        super(message);
    }
}
