package com.kyj.todo.model;

import com.kyj.todo.model.domain.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class TodoView {
    private long id;

    private String content;

    private LocalDateTime expiredAt;

    private boolean important;

    private boolean completed;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static TodoView of(Todo todo) {
        return builder()
                .id(todo.getId())
                .content(todo.getContent())
                .expiredAt(todo.getExpiredAt())
                .important(todo.isImportant())
                .completed(todo.isCompleted())
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdatedAt())
                .build();
    }
}
