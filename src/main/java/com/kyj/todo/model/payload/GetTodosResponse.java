package com.kyj.todo.model.payload;


import com.kyj.todo.model.TodoView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
@ToString
public class GetTodosResponse {

    private final List<TodoView> todos;

}
