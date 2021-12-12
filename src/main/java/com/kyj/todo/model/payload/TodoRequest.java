package com.kyj.todo.model.payload;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TodoRequest {
    private String content;

    private long expiredAt;

    private boolean importantYn;

    private boolean completedYn;

    private long createdAt;

    private long updatedAt;
}
