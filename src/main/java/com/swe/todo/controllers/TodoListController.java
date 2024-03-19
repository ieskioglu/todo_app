package com.swe.todo.controllers;

import com.swe.todo.models.TodoList;
import com.swe.todo.repositories.TodoListRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todoLists")
@Api(tags = "TodoLists")
public class TodoListController {

    @Autowired
    private final TodoListRepository repository;

    TodoListController(TodoListRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ApiOperation("Add Todo List")
    ResponseEntity<String> create(TodoList todoList) {
        repository.save(todoList);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
