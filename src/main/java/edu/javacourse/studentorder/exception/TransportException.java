package edu.javacourse.studentorder.exception;

public class TransportException extends Exception {

    public TransportException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransportException(String message) {
        super(message);
    }

    public TransportException() {

    }
}
