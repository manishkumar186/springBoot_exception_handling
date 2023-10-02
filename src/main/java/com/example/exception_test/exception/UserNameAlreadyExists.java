package com.example.exception_test.exception;

public class UserNameAlreadyExists extends Exception{

    public UserNameAlreadyExists(String message) {
        super(message);
    }
}
