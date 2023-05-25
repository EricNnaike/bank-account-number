package com.example.bankaccountnumber.exception;

import lombok.Data;

@Data
public class NotFoundError extends RuntimeException{
    public NotFoundError(String message) {
        super(message);
    }
}
