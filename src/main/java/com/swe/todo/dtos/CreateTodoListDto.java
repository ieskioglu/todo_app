package com.swe.todo.dtos;

import lombok.Data;

@Data
public class CreateTodoListDto {
    private String title;
    private String userId;
}
