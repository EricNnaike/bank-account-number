package com.example.bankaccountnumber.controller;

import com.example.bankaccountnumber.dto.ExceptionResponse;
import com.example.bankaccountnumber.exception.NotFoundError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundError.class)
    public ResponseEntity<Object> UserNotFoundException(NotFoundError exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
