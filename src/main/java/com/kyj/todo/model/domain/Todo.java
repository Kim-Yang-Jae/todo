package com.kyj.todo.model.domain;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class Todo {
    private long id;

    @NonNull
    private String content;

    @NonNull
    private LocalDateTime expiredAt;

    private boolean importantYn;

    private boolean completedYn;

    @NonNull
    private LocalDateTime createdAt;

    @NonNull
    private LocalDateTime updatedAt;
}
