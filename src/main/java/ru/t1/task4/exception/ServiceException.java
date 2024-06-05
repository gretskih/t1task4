package ru.t1.task4.exception;

public class ServiceException extends Exception {
    public ServiceException(String message, Exception exception) {
        super(message, exception);
    }
}
