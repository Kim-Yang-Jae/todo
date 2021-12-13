package com.kyj.todo.service;


import com.kyj.todo.exception.TodoException;
import com.kyj.todo.model.TodoView;
import com.kyj.todo.model.domain.Todo;
import com.kyj.todo.model.payload.GetTodosResponse;
import com.kyj.todo.model.payload.PaginationRequest;
import com.kyj.todo.model.payload.SaveTodoResponse;
import com.kyj.todo.model.payload.TodoRequest;
import com.kyj.todo.repository.TodoMapper;
import com.kyj.todo.service.converter.TodoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoMapper mapper;

    public GetTodosResponse getTodos(Long lastTodoId, int count) {
        PaginationRequest paginationRequest = (lastTodoId == null) ?
                PaginationRequest.first(count) : PaginationRequest.next(lastTodoId, count);
        List<Todo> todos = mapper.findAll(paginationRequest);

        List<TodoView> todoViews = todos.stream()
                .map(TodoView::of)
                .collect(Collectors.toList());
        return GetTodosResponse.of(todoViews);
    }

    public TodoView getTodo(long id) {
        Todo todo = mapper.findOne(id);
        if (todo == null) {
            throw new TodoException(
                    String.format("Failed to getTodo: Not found todo.(id=%d)", id), HttpStatus.NOT_FOUND);
        }
        return TodoView.of(todo);
    }

    @Transactional
    public SaveTodoResponse saveTodo(TodoRequest request) {
        Todo todo = TodoConverter.toTodo(request);
        mapper.upsert(todo);
        return SaveTodoResponse.of(todo.getId());
    }

    @Transactional
    public void deleteTodo(long id) {
        mapper.delete(id);
    }
}
