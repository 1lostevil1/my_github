package hw3.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    @DisplayName("123")
    void convertToRoman123() {
        String actual = Task4.toRoman(123);
        String expected = "CXXIII";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("3994")
    void convertToRoman3994() {
        String actual = Task4.toRoman(3994);
        String expected = "MMMCMXCIV";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("0")
    void convertToRoman0() {
        String actual = Task4.toRoman(0);
        String expected = "N";
        assertEquals(expected, actual);
    }
}
