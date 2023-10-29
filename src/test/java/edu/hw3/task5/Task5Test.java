package edu.hw3.task5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    @DisplayName("Тест 1")
    void parseContacts1() {
        Task5 task = new Task5();
        List<String> list = Arrays.asList("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes");
        String actual = task.parseContacts(list, "ASC").toString();
        String expected = "[Thomas Aquinas, Rene Descartes, David Hume, John Locke]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест 2")
    void parseContacts2() {
        Task5 task = new Task5();
        List<String> list = Arrays.asList("Paul Erdos", "Leonhard ", "Carl Gauss");
        String actual = task.parseContacts(list, "DESC").toString();
        String expected = "[Carl Gauss,Paul Erdos, Aaonhard ]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест 3")
    void parseContacts3() {
        Task5 task = new Task5();
        List<String> list = Arrays.asList();
        String actual = task.parseContacts(list, "DESC").toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }
}
