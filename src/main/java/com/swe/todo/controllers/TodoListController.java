package com.swe.todo.controllers;

import com.swe.todo.dtos.CreateTodoListDto;
import com.swe.todo.models.TodoList;
import com.swe.todo.repositories.TodoListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todoLists")
public class TodoListController {

    private final TodoListRepository repository;

    TodoListController(TodoListRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    ResponseEntity<String> get(){
        return  ResponseEntity.status(HttpStatus.OK).body("Ok");
    }

    @PostMapping("/")
    ResponseEntity<String> create(@RequestBody CreateTodoListDto request) {
        ModelMapper modelMapper = new ModelMapper();
        TodoList todoList = modelMapper.map(request,TodoList.class);
        repository.save(todoList);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Ok");
    }
}
