package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @ParameterizedTest
    // Given
    @ValueSource(strings = {"А123ВЕ777", "О777ОО177", "В456ВЕ678"})
    @DisplayName("Корректный номер")
    void isValid(String strings) {
        // When
        boolean actual = Task5.isCarNumber(strings);
        // Then
        assertTrue(actual);
    }

    @ParameterizedTest
    // Given
    @ValueSource(strings = {"АА123ВЕ777", "О7777ОО177", "А123ВЕ7777"})
    @DisplayName("Корректный номер")
    void isNotValid(String strings) {
        // When
        boolean actual = Task5.isCarNumber(strings);
        // Then
        assertFalse(actual);
    }

    @Test
    @DisplayName("Пустой номер")
    void isEmpty() {
        // When
        boolean actual = Task5.isCarNumber("");
        // Then
        assertFalse(actual);
    }

    @Test
    @DisplayName("null номер")
    void isNull() {
        // When
        boolean actual = Task5.isCarNumber(null);
        // Then
        assertFalse(actual);
    }

}

