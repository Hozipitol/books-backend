package com.users.userbackend.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("could not find the id");
    }

}
