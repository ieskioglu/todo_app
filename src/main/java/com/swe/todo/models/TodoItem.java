package com.swe.todo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.util.Date;

@Document
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private final String id;
    private final String listId;
    private final String title;
    private final String notes;
    private final Boolean priority;
    private final Date reminder;
    private final Boolean completed;
    private final Date completedDate;

    static TodoItem of(String listId, String title) {
        return new TodoItem(null, listId, title);
    }

    TodoItem(String id, String listId, String title) {
        this.id = id;
        this.listId = listId;
        this.title = title;
        this.notes = null;
        this.priority = false;
        this.reminder = null;
        this.completed = false;
        this.completedDate = null;
    }

    TodoItem(String id,
             String listId,
             String title,
             String notes,
             Boolean priority,
             Date reminder,
             Boolean completed,
             Date completedDate) {
        this.id = id;
        this.listId = listId;
        this.title = title;
        this.notes = notes;
        this.priority = priority;
        this.reminder = reminder;
        this.completed = completed;
        this.completedDate = completedDate;
    }
}
