package com.example.blogsystem_hw27.apiException;

public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);
    }
}
