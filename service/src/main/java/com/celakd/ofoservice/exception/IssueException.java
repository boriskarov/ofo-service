package com.celakd.ofoservice.exception;

public class IssueException extends RuntimeException {
    public IssueException(String message) {
        super(message);
    }

    public IssueException(String message, Throwable cause) {
        super(message, cause);
    }
}
