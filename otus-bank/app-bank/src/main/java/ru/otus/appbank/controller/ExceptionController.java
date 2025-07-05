package ru.otus.appbank.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.otus.appbank.exception.NoDataFoundException;

@Component
@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<String> exceptionHandler(NoDataFoundException exp) {
        return
                new ResponseEntity<>(exp.toString(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> exceptionHandler(RuntimeException exp) {
        return
                new ResponseEntity<>(exp.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
