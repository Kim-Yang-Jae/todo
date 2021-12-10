package com.kyj.todo.model.payload;


import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@ToString
public class TodoRequest {
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String content;

    private boolean importantYn;

    private LocalDateTime expiredAt;

    private boolean completedYn;
}
