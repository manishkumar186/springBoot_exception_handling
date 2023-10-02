package com.example.exception_test.exception;

public class EmailAlreadyExists extends Exception{
    public EmailAlreadyExists(String message) {
        super(message);
    }
}
