package com.celakd.ofoservice.exception;


public class ProcessException extends RuntimeException{
    public ProcessException(String message){
        super(message);
    }

    public ProcessException(String message, Throwable cause){
        super(message, cause);
    }
}
