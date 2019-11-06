package com.example.testProject;

import java.util.Arrays;
import java.util.List;

public class TodoServiceImpl implements TodoService {
    @Override
    public List<String> getTodoList(String user) {
        return Arrays.asList("test", "test1", "test2");
    }

    @Override
    public void deleteTodo(String todo) {

    }
}
