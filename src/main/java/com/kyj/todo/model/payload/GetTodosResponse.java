package com.kyj.todo.model.payload;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
public class GetTodosResponse {

    private final List<String> todos;

}
