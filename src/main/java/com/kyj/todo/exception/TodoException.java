package com.kyj.todo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TodoException extends RuntimeException {
    private final HttpStatus httpStatus;

    public TodoException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public TodoException(Throwable cause) {
        this(cause.getMessage(), cause, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public TodoException(String message, Throwable cause) {
        this(message, cause, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public TodoException(Throwable cause, HttpStatus httpStatus) {
        this(cause.getMessage(), cause, httpStatus);
    }

    public TodoException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public TodoException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }
}
