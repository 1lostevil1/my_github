package edu.hw3.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    @DisplayName("Слова по 2 раза")
    void freqDictStrTo2() {
        List<?> list = Arrays.asList("a", "bb", "a", "bb");
        String actual = Task3.freqDict(list).toString();
        String expected = "{bb=2, a=2}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Слова по несколько раз")
    void freqDictStr() {
        List<?> list = Arrays.asList("this", "and", "that", "and", "that", "that", "that");
        String actual = Task3.freqDict(list).toString();
        String expected = "{that=4, and=2, this=1}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Числа")
    void freqDictInt() {
        List<?> list = Arrays.asList(1, 1, 2, 2);
        String actual = Task3.freqDict(list).toString();
        String expected = "{1=2, 2=2}";
        assertEquals(expected, actual);
    }
}
