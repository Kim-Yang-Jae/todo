package com.kyj.todo.controller;

import com.kyj.todo.config.SwaggerTag;
import com.kyj.todo.model.TodoView;
import com.kyj.todo.model.payload.GetTodosResponse;
import com.kyj.todo.model.payload.SaveTodoResponse;
import com.kyj.todo.model.payload.TodoRequest;
import com.kyj.todo.service.TodoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = SwaggerTag.Todo.TAG, description = SwaggerTag.Todo.DESC)
@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService service;

    @GetMapping("/")
    public GetTodosResponse getTodos() {
        return service.getTodos();
    }

    @PutMapping("/")
    public SaveTodoResponse saveTodo(@RequestBody TodoRequest request) {
        return service.saveTodo(request);
    }

    @GetMapping("/{todoId}")
    public TodoView getTodo(@PathVariable long todoId) {
        return service.getTodo(todoId);
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable long todoId) {
        service.deleteTodo(todoId);
    }
}
