package com.example.testProject;

import java.util.List;

public interface TodoService {
    public List<String> getTodoList(String user);

    public void deleteTodo(String todo);
}
