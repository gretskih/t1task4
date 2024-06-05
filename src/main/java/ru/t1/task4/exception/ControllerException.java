package ru.t1.task4.exception;

public class ControllerException extends Exception {
    public ControllerException(String message, Exception exception) {
        super(message, exception);
    }
}
