package com.kyj.todo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class TodoError {
    private final int code;
    private final String status;
    private final String message;
}
