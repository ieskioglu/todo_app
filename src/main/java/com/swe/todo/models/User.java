package com.swe.todo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Document
public class User {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private final String id;
    private final String email;
    private final String password;

    static User of(String email, String password){
        return new User(null, email, password);
    }

    User(String id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
