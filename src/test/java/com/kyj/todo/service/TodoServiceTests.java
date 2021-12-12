package com.kyj.todo.service;


import com.kyj.todo.config.SpringBootMybatisTest;
import com.kyj.todo.exception.TodoException;
import com.kyj.todo.model.TodoView;
import com.kyj.todo.model.payload.GetTodosResponse;
import com.kyj.todo.model.payload.SaveTodoResponse;
import com.kyj.todo.model.payload.TodoRequest;
import com.kyj.todo.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@SpringBootMybatisTest
public class TodoServiceTests {
    @Autowired
    private TodoService todoService;

    @DisplayName("Todo 전체 조회 테스트")
    @Test
    public void get_todos_test() {
        GetTodosResponse response = todoService.getTodos();
        log.info("All Todos: {}", response.getTodos());
    }

    @DisplayName("Todo 생성 테스트")
    @Test
    public void save_todo_test() {
        TodoRequest request = new TodoRequest();
        request.setContent("Todo test");
        request.setExpiredAt(1639200630053L);
        request.setImportantYn(true);
        request.setCompletedYn(false);
        request.setCreatedAt(1639200630053L);
        request.setUpdatedAt(1639200630053L);
        SaveTodoResponse saveTodoResponse = todoService.saveTodo(request);

        TodoView todo = todoService.getTodo(saveTodoResponse.getId());
        Assertions.assertEquals(request.getContent(), todo.getContent());
        Assertions.assertEquals(TimeUtils.toLocalDateTime(request.getExpiredAt()), todo.getExpiredAt());
        Assertions.assertEquals(request.isImportantYn(), todo.isImportantYn());
        Assertions.assertEquals(request.isCompletedYn(), todo.isCompletedYn());
        Assertions.assertEquals(TimeUtils.toLocalDateTime(request.getCreatedAt()), todo.getCreatedAt());
        Assertions.assertEquals(TimeUtils.toLocalDateTime(request.getUpdatedAt()), todo.getUpdatedAt());
    }

    @DisplayName("Todo 삭제 테스트")
    @Test
    public void delete_todo_test() {
        TodoRequest request = new TodoRequest();
        request.setContent("Todo test");
        request.setExpiredAt(1639200630053L);
        request.setImportantYn(true);
        request.setCompletedYn(false);
        request.setCreatedAt(1639200630053L);
        request.setUpdatedAt(1639200630053L);
        SaveTodoResponse saveTodoResponse = todoService.saveTodo(request);
        long id = saveTodoResponse.getId();

        TodoView savedTodoView = todoService.getTodo(id);
        log.info("Saved todoView: {}", savedTodoView);

        todoService.deleteTodo(id);
        Assertions.assertThrows(TodoException.class, () -> {
            TodoView deletedTodoView = todoService.getTodo(id);
            log.info("Deleted todoView: {}", deletedTodoView);
        });
    }
}

