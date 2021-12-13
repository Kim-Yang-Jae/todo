package com.kyj.todo.service.converter;

import com.kyj.todo.model.domain.Todo;
import com.kyj.todo.model.payload.TodoRequest;
import com.kyj.todo.util.IdGenerator;
import com.kyj.todo.util.TimeUtils;

public class TodoConverter {

    public static Todo toTodo(TodoRequest request){
        long id = IdGenerator.getInstance().generate();
        return  Todo.builder()
                .id(id)
                .content(request.getContent())
                .expiredAt(TimeUtils.toLocalDateTime(request.getExpiredAt()))
                .important(request.isImportant())
                .completed(request.isCompleted())
                .createdAt(TimeUtils.toLocalDateTime(request.getCreatedAt()))
                .updatedAt(TimeUtils.toLocalDateTime(request.getUpdatedAt()))
                .build();
    }

}
