package ru.x5.mongotest.exception;

public class CisDoesNotExistException extends RuntimeException {
    public CisDoesNotExistException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public CisDoesNotExistException(String message) {
        super(message);
    }
}