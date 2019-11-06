package com.example.testProject;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class TodoServiceMockitoTest {

    @Test
    public void getTodoListTest_randomList() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> list = Arrays.asList("test", "test1", "test2");
        when(todoServiceMock.getTodoList("test")).thenReturn(list);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        assertEquals(list, todoBusinessImpl.getTodoList("test"));
    }

    @Test
    public void getTodoListTest_emptyList() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> list = Arrays.asList();
        when(todoServiceMock.getTodoList("test")).thenReturn(list);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        assertEquals(0, todoBusinessImpl.getTodoList("test").size());
    }

    @Test
    public void getTodoListTest_randomListUsingBDD() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> list = Arrays.asList("test", "test1", "test2");
        given(todoServiceMock.getTodoList("test")).willReturn(list);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        assertThat(todoBusinessImpl.getTodoList("test"), is(list));
    }

    @Test
    public void getTodoListTest_emptyListUsingBDD() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> list = Arrays.asList();
        given(todoServiceMock.getTodoList("test")).willReturn(list);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        assertThat(todoBusinessImpl.getTodoList("test").size(), is(0));
    }

    @Test
    public void deleteTodoUsingBDD() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> list = Arrays.asList("test", "test1", "test2");
        given(todoServiceMock.getTodoList("test")).willReturn(list);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        todoBusinessImpl.deleteTodo("test2");

        verify(todoServiceMock, atLeastOnce()).deleteTodo("test2");
        then(todoServiceMock).should().deleteTodo("test2");

        verify(todoServiceMock, never()).deleteTodo("test1");
        then(todoServiceMock).should(never()).deleteTodo("test1");
    }

    @Test
    public void deleteTodoUsingBDDWithThen() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> list = Arrays.asList("test", "test1", "test2");
        given(todoServiceMock.getTodoList("test")).willReturn(list);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        todoBusinessImpl.deleteTodo("test2");

        then(todoServiceMock).should().deleteTodo("test2");

        then(todoServiceMock).should(never()).deleteTodo("test1");
    }

    @Test
    public void deleteTodoUsingBDDArgumentCapture() {
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> list = Arrays.asList("test", "test1", "test2");
        given(todoServiceMock.getTodoList("test")).willReturn(list);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        todoBusinessImpl.deleteTodo("test2");

        then(todoServiceMock).should().deleteTodo(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), is("test2"));
        assertThat(argumentCaptor.getAllValues().size(), is(1));

    }

}
