package com.kyj.todo.model;

import com.kyj.todo.model.domain.Todo;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class TodoView {
    private long id;

    private String content;

    private LocalDateTime expiredAt;

    private boolean importantYn;

    private boolean completedYn;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static TodoView of(Todo todo) {
        return builder()
                .id(todo.getId())
                .content(todo.getContent())
                .expiredAt(todo.getExpiredAt())
                .importantYn(todo.isImportantYn())
                .completedYn(todo.isCompletedYn())
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdatedAt())
                .build();
    }
}
