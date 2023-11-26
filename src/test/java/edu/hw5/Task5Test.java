package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @ParameterizedTest
    @ValueSource(strings = {"А123ВЕ777", "О777ОО177", "В456ВЕ678"})
    @DisplayName("Корректный номер")
    void isValid(String strings) {
        // when
        boolean actual = Task5.isCarNumber(strings);
        // then
        assertTrue(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"АА123ВЕ777", "О7777ОО177", "А123ВЕ7777"})
    @DisplayName("Корректный номер")
    void isNotValid(String strings) {
        // when
        boolean actual = Task5.isCarNumber(strings);
        // then
        assertFalse(actual);
    }

    @Test
    @DisplayName("Пустой номер")
    void isEmpty() {
        // when
        boolean actual = Task5.isCarNumber("");
        // then
        assertFalse(actual);
    }

    @Test
    @DisplayName("null номер")
    void isNull() {
        // when
        boolean actual = Task5.isCarNumber(null);
        // then
        assertFalse(actual);
    }

}

