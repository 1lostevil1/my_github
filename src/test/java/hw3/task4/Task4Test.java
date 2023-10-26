package hw3.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    @DisplayName("1628")
    void convertToRoman123() {
        String actual = Task4.toRoman(123);
        String expected = "CXXIII";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("1628")
    void convertToRoman4994() {
        String actual = Task4.toRoman(4994);
        String expected = "MMMMCMXCIV";
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
