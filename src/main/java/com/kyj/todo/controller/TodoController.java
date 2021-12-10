package com.kyj.todo.controller;

import com.kyj.todo.model.payload.B;
import com.kyj.todo.model.payload.GetTodosResponse;
import com.kyj.todo.model.payload.A;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @GetMapping("/")
    public GetTodosResponse getTodos() {
        B b = B.builder()
                .a("")
                .b("")
                .c("")
                .d("")
                .build();
        A a = A.of(b);
        return GetTodosResponse.builder().build();
    }

}
