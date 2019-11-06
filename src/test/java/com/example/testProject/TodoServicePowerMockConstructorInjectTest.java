package com.example.testProject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
public class TodoServicePowerMockConstructorInjectTest {

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Mock
    ArrayList mockList;

    @Test
    public void getTodoListTest_randomList() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3);
        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
        assertEquals(mockList.size(), systemUnderTest.methodUsingAnArrayListConstructor());
    }
}
