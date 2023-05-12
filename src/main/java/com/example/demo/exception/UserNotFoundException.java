package com.example.demo.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(long id) {
        super("Could not found with id: "+id);
    }
}
