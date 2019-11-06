package com.example.testProject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class TodoServicePowerMockInjectTest {

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void getTodoListTest_randomList() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        when(dependency.retrieveAllStats()).thenReturn(list);
        PowerMockito.mockStatic(UtilityClass.class);
        when(UtilityClass.staticMethod(6)).thenReturn(150);
        assertEquals(150, systemUnderTest.methodCallingAStaticMethod());
        PowerMockito.verifyStatic(UtilityClass.class);
        UtilityClass.staticMethod(6);

    }
}
