package com.example.testProject;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringHelperParameterTest {

    StringHelper stringHelper = new StringHelper();

    public static Collection data() {
        String[][] output = {{"ABCD", "BCD"}, {"AAAA", "AA"}};
        return Arrays.asList(output);
    }

    @ParameterizedTest
    @MethodSource("data")
    void testTruncateAInFirst2Positions(String input, String output) {
        assertEquals(output, stringHelper.truncateAInFirst2Positions(input));
    }
}