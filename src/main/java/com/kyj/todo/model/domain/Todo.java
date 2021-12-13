package com.kyj.todo.model.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

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

    private final boolean important;

    private final boolean completed;

    @NonNull
    private final LocalDateTime createdAt;

    @NonNull
    private final LocalDateTime updatedAt;
}
