package com.example.testProject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringHelperTest {

    StringHelper stringHelper = new StringHelper();

    @Test
    void testTruncateAInFirst2Positions_AinFirstPosition() {
        assertEquals("BCD", stringHelper.truncateAInFirst2Positions("ABCD"));
    }

    @Test
    void testTruncateAInFirst2Positions_AinFirst2Positions() {
        assertEquals("AA", stringHelper.truncateAInFirst2Positions("AAAA"));
    }

    @Test
    void testAreFirstAndLastTwoCharactersTheSame_BasicPositive() {
        assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("AAAA"));
    }

    @Test
    void testAreFirstAndLastTwoCharactersTheSame_BasicNegative() {
        assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }
}