package edu.hw3.task2;

import edu.hw3.task2.Task2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    @DisplayName("тесты с сайта")
    void baseTests() {
        String actual = Task2.clusterize("()()()");
        String expected = "[\"()\", \"()\", \"()\"]";
        assertEquals(expected, actual);

        actual = Task2.clusterize("((()))");
        expected = "[\"((()))\"]";
        assertEquals(expected, actual);

        actual = Task2.clusterize("((()))(())()()(()())");
        expected = "[\"((()))\", \"(())\", \"()\", \"()\", \"(()())\"]";
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("тест ввода некорректной строки ")
    void IncorrectInputTest() {
        String actual = Task2.clusterize("(d)");
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поверка несбалансированной строки")
    void ImbalanceTest() {
        String actual = Task2.clusterize("((()))(())()()())");
        String expected = "";
        assertEquals(expected, actual);
    }
}

