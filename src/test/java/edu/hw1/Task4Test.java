package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    @Test
    void isNested() {

        String actual = Task4.fixString("badce");
        String expected = "abcde";
        assertEquals(actual, expected);

        actual = Task4.fixString("123456");
        expected = "214365";
        assertEquals(actual, expected);

        actual = Task4.fixString("123 a 456");
        expected = "This is a mixed up string.";
        assertEquals(actual, expected);
    }

}
