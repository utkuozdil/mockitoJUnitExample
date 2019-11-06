package com.example.testProject;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysCompareTest {

    @Test
    void testArraySort__basicArray() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] result = {1, 3, 2, 5, 4};
        Arrays.sort(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void testArraySort__nullArray() {
        int[] expected = null;
        assertThrows(NullPointerException.class, () ->
                Arrays.sort(expected));
    }

    @Test
    void testArraySort__performance() {
        assertTimeout(Duration.ofMillis(25), () -> {
            int[] array = {1, 3, 2, 5, 4};
            for (int i = 1; i < 1000000; i++) {
                array[0] = i;
                Arrays.sort(array);
            }
        });
    }
}