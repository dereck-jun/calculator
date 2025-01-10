package com.example.challenge.exception;

public class BaseException extends RuntimeException {

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
        System.out.println(message);
    }
}
