package com.example.lv2.exception;

public class ClientException extends RuntimeException {
    public ClientException() {
    }

    public ClientException(String message) {
        super(message);
        System.out.println(message);
    }
}
