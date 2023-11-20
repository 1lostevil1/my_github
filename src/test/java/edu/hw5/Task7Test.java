package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Task7Test {
    @ParameterizedTest
    // Given
    @ValueSource(strings = {"1001", "110111", "110", "000", "010"})
    @DisplayName("Правильная строка(1й пункт)")
    void isValid1(String strings) {
        // When
        boolean actual = Task7.isValidString(strings, Task7.FIRST_PATTERN);
        // Then
        assertTrue(actual);

    }

    @ParameterizedTest
    // Given
    @ValueSource(strings = {"101", "111323", "111111", "001", "22232323"})
    @DisplayName("Неправильная строка(1й пункт)")
    void isNotValid1(String strings) {
        // When
        boolean actual = Task7.isValidString(strings, Task7.FIRST_PATTERN);
        // Then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Пустая строка(1й пункт)")
    void empty1() {
        // When
        boolean actual = Task7.isValidString("", Task7.FIRST_PATTERN);
        // Then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Null(1 пункт)")
    void null1() {
        // When
        boolean actual = Task7.isValidString(null, Task7.FIRST_PATTERN);
        // Then
        assertFalse(actual);

    }

    @ParameterizedTest
    // Given
    @ValueSource(strings = {"1010101", "11", "1"})
    @DisplayName("Правильная строка(2й пункт)")
    void isValid2(String strings) {
        // When
        boolean actual = Task7.isValidString(strings, Task7.SECOND_PATTERN);
        // Then
        assertTrue(actual);

    }

    @ParameterizedTest
    // Given
    @ValueSource(strings = {"100", "011", "101001010", "10120023010"})
    @DisplayName("Неправильная строка(2й пункт)")
    void isNotValid2(String strings) {
        // When
        boolean actual = Task7.isValidString(strings, Task7.SECOND_PATTERN);
        // Then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Пустая строка(2й пункт)")
    void empty2() {
        // When
        boolean actual = Task7.isValidString("", Task7.SECOND_PATTERN);
        // Then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Null(2 пункт)")
    void null2() {
        // When
        boolean actual = Task7.isValidString(null, Task7.SECOND_PATTERN);
        // Then
        assertFalse(actual);

    }

    @ParameterizedTest
    // Given
    @ValueSource(strings = {"111", "000", "101", "11", "00"})
    @DisplayName("Правильная строка(3й пункт)")
    void isValid3(String strings) {
        // When
        boolean actual = Task7.isValidString(strings, Task7.THIRD_PATTERN);
        // Then
        assertTrue(actual);

    }

    @ParameterizedTest
    // Given
    @ValueSource(strings = {"1101", "101010", "323"})
    @DisplayName("Неправильная строка(3й пункт)")
    void isNotValid3(String strings) {
        // When
        boolean actual = Task7.isValidString(strings, Task7.THIRD_PATTERN);
        // Then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Пустая строка(3й пункт)")
    void empty3() {
        // When
        boolean actual = Task7.isValidString("", Task7.THIRD_PATTERN);
        // Then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Null(3 пункт)")
    void null3() {
        // When
        boolean actual = Task7.isValidString(null, Task7.THIRD_PATTERN);
        // Then
        assertFalse(actual);

    }

}
