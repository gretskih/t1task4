package ru.t1.task4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.t1.task4.dto.ErrorMessage;
import ru.t1.task4.exception.ControllerException;

@RestControllerAdvice(
        assignableTypes = {AccountController.class}
)
public class ErrorHandlerController {

    @ExceptionHandler(ControllerException.class)
    public ResponseEntity<ErrorMessage> onHandleException(ControllerException e) {
        return ResponseEntity.badRequest()
                .body(new ErrorMessage(e.getCause().toString(), e.getCause().getCause().getMessage()));
    }
}
