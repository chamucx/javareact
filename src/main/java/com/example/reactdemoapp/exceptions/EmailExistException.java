package com.example.reactdemoapp.exceptions;

public class EmailExistException extends RuntimeException{

    public static final long serialVersionUID = 1L;

    public EmailExistException(String message){
        super(message);
    }

}
