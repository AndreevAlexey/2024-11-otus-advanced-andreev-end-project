package ru.otus.appbank.exception;

public class NoDataFoundException extends RuntimeException{

    public NoDataFoundException(String message) {
        super(message);
    }
}
