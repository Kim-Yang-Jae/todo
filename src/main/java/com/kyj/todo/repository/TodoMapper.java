package com.kyj.todo.repository;

import com.kyj.todo.model.domain.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    List<Todo> findAll();

    Todo findOne(long id);

    void upsert(Todo todo);

    void delete(long id);

}
