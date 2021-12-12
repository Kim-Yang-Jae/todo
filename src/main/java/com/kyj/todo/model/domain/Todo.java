package com.kyj.todo.model.domain;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class Todo {
    private final long id;

    @NonNull
    private final String content;

    @NonNull
    private final LocalDateTime expiredAt;

    private final boolean importantYn;

    private final boolean completedYn;

    @NonNull
    private final LocalDateTime createdAt;

    @NonNull
    private final LocalDateTime updatedAt;
}
