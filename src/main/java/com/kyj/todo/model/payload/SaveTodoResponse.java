package com.kyj.todo.model.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(staticName = "of")
@ToString
public class SaveTodoResponse {

    private final long id;

}
