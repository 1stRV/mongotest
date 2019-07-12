package ru.x5.mongotest.exception;

public class ProductDoesNotExistException extends RuntimeException {
    public ProductDoesNotExistException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ProductDoesNotExistException(String message) {
        super(message);
    }
}