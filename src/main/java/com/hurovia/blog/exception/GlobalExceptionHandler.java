package com.hurovia.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler
    public ResponseEntity<String> handlePostNotFoundException(PostNotFoundException postNotFoundException){
        return new ResponseEntity<>(postNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleInvalidInputException(InvalidInputException invalidInputException){
        return new ResponseEntity<>(invalidInputException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> handlePersistenceException(PersistenceException persistenceException){
        return new ResponseEntity<>(persistenceException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
