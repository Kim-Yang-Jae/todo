package com.kyj.todo.config;

import com.kyj.todo.exception.TodoException;
import com.kyj.todo.model.TodoError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<TodoError> handle(Throwable cause) {
        return handle(new TodoException(cause));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<TodoError> handle(Exception exception) {
        return handle(new TodoException(exception));
    }

    @ExceptionHandler(TodoException.class)
    public ResponseEntity<TodoError> handle(TodoException exception) {
        HttpStatus httpStatus = exception.getHttpStatus();
        TodoError error = TodoError.builder()
                .code(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .message(exception.getMessage())
                .build();

        if (httpStatus.is4xxClientError()) {
            if (httpStatus.value() == 404) {
                log.error("Not found error({})", error.getMessage());
            } else {
                log.error(error.getMessage());
            }
        } else {
            log.error(error.getMessage(), exception);
        }
        return ResponseEntity.status(httpStatus).body(error);
    }

}
