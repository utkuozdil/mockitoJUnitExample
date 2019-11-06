package com.example.testProject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TodoServiceMockitoInjectTest {

    @Mock
    TodoService todoServiceMock;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> argumentCaptor;


    @Test
    public void getTodoListTest_randomList() {
        List<String> list = Arrays.asList("test", "test1", "test2");
        when(todoServiceMock.getTodoList("test")).thenReturn(list);
        assertEquals(list, todoBusinessImpl.getTodoList("test"));
    }

    @Test
    public void getTodoListTest_emptyList() {
        List<String> list = Arrays.asList();
        when(todoServiceMock.getTodoList("test")).thenReturn(list);
        assertEquals(0, todoBusinessImpl.getTodoList("test").size());
    }

    @Test
    public void getTodoListTest_randomListUsingBDD() {
        List<String> list = Arrays.asList("test", "test1", "test2");
        given(todoServiceMock.getTodoList("test")).willReturn(list);
        assertThat(todoBusinessImpl.getTodoList("test"), is(list));
    }

    @Test
    public void getTodoListTest_emptyListUsingBDD() {
        List<String> list = Arrays.asList();
        given(todoServiceMock.getTodoList("test")).willReturn(list);
        assertThat(todoBusinessImpl.getTodoList("test").size(), is(0));
    }

    @Test
    public void deleteTodoUsingBDD() {
        List<String> list = Arrays.asList("test", "test1", "test2");
        given(todoServiceMock.getTodoList("test")).willReturn(list);
        todoBusinessImpl.deleteTodo("test2");

        verify(todoServiceMock, atLeastOnce()).deleteTodo("test2");
        then(todoServiceMock).should().deleteTodo("test2");

        verify(todoServiceMock, never()).deleteTodo("test1");
        then(todoServiceMock).should(never()).deleteTodo("test1");
    }

    @Test
    public void deleteTodoUsingBDDWithThen() {
        List<String> list = Arrays.asList("test", "test1", "test2");
        given(todoServiceMock.getTodoList("test")).willReturn(list);
        todoBusinessImpl.deleteTodo("test2");

        then(todoServiceMock).should().deleteTodo("test2");

        then(todoServiceMock).should(never()).deleteTodo("test1");
    }

    @Test
    public void deleteTodoUsingBDDArgumentCapture() {
        List<String> list = Arrays.asList("test", "test1", "test2");
        given(todoServiceMock.getTodoList("test")).willReturn(list);
        todoBusinessImpl.deleteTodo("test2");

        then(todoServiceMock).should().deleteTodo(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), is("test2"));
        assertThat(argumentCaptor.getAllValues().size(), is(1));
    }
}
