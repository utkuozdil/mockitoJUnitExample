package com.example.testProject;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMockitoTest {

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(22, 23, 25, 14, 66, 55);
        assertThat(list, hasSize(6));
        assertThat(list, hasItems(55, 14));
        assertThat(list, everyItem(greaterThan(10)));

        Integer[] array = {1, 2, 3};
        assertThat(array, arrayWithSize(3));
        assertThat(array, arrayContaining(1, 2, 3));
        assertThat(array, arrayContainingInAnyOrder(1, 2, 3));
    }
}
