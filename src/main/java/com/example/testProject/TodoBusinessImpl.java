package com.example.testProject;

import java.util.List;

public class TodoBusinessImpl {

    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> getTodoList(String user) {
        return todoService.getTodoList(user);
    }

    public void deleteTodo(String todo) {
        todoService.deleteTodo(todo);
    }
}
