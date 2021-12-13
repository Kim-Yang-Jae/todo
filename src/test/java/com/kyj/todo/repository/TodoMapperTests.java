package com.kyj.todo.repository;


import com.kyj.todo.model.domain.Todo;
import com.kyj.todo.util.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.time.LocalDateTime;

@Slf4j
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TodoMapperTests {
    @Autowired
    private TodoMapper mapper;

    @DisplayName("Todo upsert test")
    @Test
    public void upsert_test() {
        Todo todo = Todo.builder()
                .id(IdGenerator.getInstance().generate())
                .content("test")
                .expiredAt(LocalDateTime.of(2021, 12, 10, 10, 11, 12))
                .important(true)
                .completed(false)
                .createdAt(LocalDateTime.of(2021, 12, 9, 20, 0, 0))
                .updatedAt(LocalDateTime.of(2021, 12, 9, 20, 0, 0))
                .build();
        mapper.upsert(todo);

        Todo foundTodo = mapper.findOne(todo.getId());
        log.info("found Todo: {}", foundTodo);

        Assertions.assertEquals(todo.getId(), foundTodo.getId());
        Assertions.assertEquals(todo.getContent(), foundTodo.getContent());
        Assertions.assertEquals(todo.getExpiredAt(), foundTodo.getExpiredAt());
        Assertions.assertEquals(todo.isImportant(), foundTodo.isImportant());
        Assertions.assertEquals(todo.isCompleted(), foundTodo.isCompleted());
        Assertions.assertEquals(todo.getCreatedAt(), foundTodo.getCreatedAt());
        Assertions.assertEquals(todo.getUpdatedAt(), foundTodo.getUpdatedAt());
    }

    @DisplayName("Todo delete test")
    @Test
    public void delete_test() {
        Todo todo = Todo.builder()
                .id(IdGenerator.getInstance().generate())
                .content("test")
                .expiredAt(LocalDateTime.of(2021, 12, 10, 10, 11, 12))
                .important(true)
                .completed(false)
                .createdAt(LocalDateTime.of(2021, 12, 9, 20, 0, 0))
                .updatedAt(LocalDateTime.of(2021, 12, 9, 20, 0, 0))
                .build();
        mapper.upsert(todo);
        mapper.delete(todo.getId());

        Todo foundTodo = mapper.findOne(todo.getId());
        Assertions.assertNull(foundTodo);
    }
}
