package edu.miracosta.cs112.finalproject.finalproject;

public class IllegalBetException extends RuntimeException {

    public IllegalBetException(String message) {
        super(message);
    }
    public IllegalBetException(String message, Throwable cause) {
        super(message, cause);
    }
}
