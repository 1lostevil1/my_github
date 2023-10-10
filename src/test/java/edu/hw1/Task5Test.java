package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void isPalindromeDescendant() {
        boolean actual = Task5.isPalindromeDescendant(123312);
        boolean expected = true;
        assertEquals(expected, actual);

        actual = Task5.isPalindromeDescendant(11211230);
        assertEquals(expected, actual);

        actual = Task5.isPalindromeDescendant(13001120);
        assertEquals(expected, actual);

        actual = Task5.isPalindromeDescendant(0);
        assertEquals(expected, actual);

        actual = Task5.isPalindromeDescendant(1234);
        expected = false;
        assertEquals(expected, actual);

        actual = Task5.isPalindromeDescendant(623451);
        expected = false;
        assertEquals(expected, actual);

    }
}
