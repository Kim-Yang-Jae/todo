package com.kyj.todo.repository;

import com.kyj.todo.model.domain.Todo;
import com.kyj.todo.model.payload.PaginationRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    List<Todo> findAll(PaginationRequest paginationRequest);

    Todo findOne(long id);

    void upsert(Todo todo);

    void delete(long id);

}
