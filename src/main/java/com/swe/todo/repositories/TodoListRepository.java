package com.swe.todo.repositories;

import com.swe.todo.models.TodoList;
import org.springframework.data.repository.CrudRepository;

public interface TodoListRepository extends CrudRepository<TodoList,String> {
}
