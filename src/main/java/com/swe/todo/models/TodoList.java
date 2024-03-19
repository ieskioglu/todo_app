package com.swe.todo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.util.Date;

@Document
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private final String id;
    private final String title;
    private final String userId;
    private final Date created;

    static TodoList of(String title, String userId){
        return new TodoList(
                null,
                title,
                userId,
                new Date());
    }

    TodoList(String id, String title, String userId, Date created){
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.created = created;
    }

    TodoList withId(String id){
        return new TodoList(id, this.title, this.userId, this.created);
    }
}
