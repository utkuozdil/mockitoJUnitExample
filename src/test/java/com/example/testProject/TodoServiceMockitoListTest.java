package com.example.testProject;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TodoServiceMockitoListTest {

    @Test
    public void testListSize() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
    }

    @Test
    public void testListItem() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("test");
        assertEquals("test", listMock.get(0));
        assertEquals("test", listMock.get(1));
    }

    @Test
    public void testListItemUsinBDD() {
        List listMock = mock(List.class);
        given(listMock.get(anyInt())).willReturn("test");
        assertThat( listMock.get(0), is("test"));
        assertThat( listMock.get(1), is("test"));
    }

    @Test
    public void testListException() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("test exception"));
        assertThrows(RuntimeException.class, () ->
                listMock.get(0));
    }
}
