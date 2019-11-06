package com.example.testProject;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

public class TodoServiceMockitoSpyTest {

    @Test
    public void test() {
        List arrayListSpy = spy(ArrayList.class);
        when(arrayListSpy.size()).thenReturn(5);
        arrayListSpy.add("test1");
        assertEquals(5, arrayListSpy.size());
        verify(arrayListSpy).add("test1");
    }
}
