package com.assignment.HelloWorld.ErrorHandling;

public class NullOrEmptyException extends Exception {
    public NullOrEmptyException(String errorMessage) {
        super(errorMessage);
    }
}
