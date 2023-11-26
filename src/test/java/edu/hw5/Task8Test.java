package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Task8Test {
    @ParameterizedTest
    @ValueSource(strings = {"10011", "1101111", "110", "000", "010"})
    @DisplayName("Правильная строка(1й пункт)")
    void isValid1(String strings) {
        // when
        boolean actual = Task8.isValidString(strings, Task8.STRING_PATTERN_1);
        // then
        assertTrue(actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"1011", "111323", "111111", "0010", "22232323"})
    @DisplayName("Неправильная строка(1й пункт)")
    void isNotValid1(String strings) {
        // when
        boolean actual = Task8.isValidString(strings, Task8.STRING_PATTERN_1);
        // then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Пустая строка(1й пункт)")
    void empty1() {
        // when
        boolean actual = Task8.isValidString(" ", Task8.STRING_PATTERN_1);
        // then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Null(1й пункт)")
    void null1() {
        // when
        boolean actual = Task8.isValidString(null, Task8.STRING_PATTERN_1);
        // then
        assertFalse(actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"010", "1101", "1101", "000", "010"})
    @DisplayName("Правильная строка(2й пункт)")
    void isValid2(String strings) {
        // when
        boolean actual = Task8.isValidString(strings, Task8.STRING_PATTERN_2);
        // then
        assertTrue(actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"0110", "111323", "11111", "0010", "22232323"})
    @DisplayName("Неправильная строка(2й пункт)")
    void isNotValid2(String strings) {
        // when
        boolean actual = Task8.isValidString(strings, Task8.STRING_PATTERN_2);
        // then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Пустая строка(2й пункт)")
    void empty2() {
        // when
        boolean actual = Task8.isValidString(" ", Task8.STRING_PATTERN_2);
        // then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Null(2й пункт)")
    void null2() {
        // when
        boolean actual = Task8.isValidString(null, Task8.STRING_PATTERN_2);
        // then
        assertFalse(actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"1010", "1111111", "111", "1"})
    @DisplayName("Правильная строка(3й пункт)")
    void isValid3(String strings) {
        // when
        boolean actual = Task8.isValidString(strings, Task8.STRING_PATTERN_3);
        // then
        assertTrue(actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"010", "000", "100"})
    @DisplayName("Неправильная строка(3й пункт)")
    void isNotValid3(String strings) {
        // when
        boolean actual = Task8.isValidString(strings, Task8.STRING_PATTERN_3);
        // then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Пустая строка(3й пункт)")
    void empty3() {
        // when
        boolean actual = Task8.isValidString(" ", Task8.STRING_PATTERN_3);
        // when
        assertFalse(actual);

    }

    @Test
    @DisplayName("Null(3й пункт)")
    void null3() {
        // when
        boolean actual = Task8.isValidString(null, Task8.STRING_PATTERN_3);
        // then
        assertFalse(actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"1010", "0000", "10101"})
    @DisplayName("Правильная строка(4й пункт)")
    void isValid4(String strings) {
        // when
        boolean actual = Task8.isValidString(strings, Task8.STRING_PATTERN_4);
        // then
        assertTrue(actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"011", "111", "101011"})
    @DisplayName("Неправильная строка(4й пункт)")
    void isNotValid4(String strings) {
        // when
        boolean actual = Task8.isValidString(strings, Task8.STRING_PATTERN_4);
        // then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Пустая строка(4й пункт)")
    void empty4() {
        // when
        boolean actual = Task8.isValidString(" ", Task8.STRING_PATTERN_4);
        // then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Null(4й пункт)")
    void null4() {
        // when
        boolean actual = Task8.isValidString(null, Task8.STRING_PATTERN_4);
        // then
        assertFalse(actual);

    }
}
