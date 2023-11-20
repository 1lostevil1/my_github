package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @ParameterizedTest
    // Given
    @ValueSource(strings = {"~asdf~", "!asdf!", "@asdf@", "#asfd#", "$qwerty$",
        "%qwerty%", "^qwerty^", "&asds&", "*qwerty*", "|asdf|", "qwerty~!@#$%^&*|"})
    @DisplayName("Пароль содержит требуемые символы")
    void isValid(String strings) {
        // When
        boolean actual = Task4.isPassword(strings);
        // Then
        assertTrue(actual);
    }

    @Test
    @DisplayName("Пароль не содержит необходимые символы")
    void isNotValid() {
        // When
        boolean actual = Task4.isPassword("abcde");
        // Then
        assertFalse(actual);
    }

    @Test
    @DisplayName("Пустой пароль")
    void isEmpty() {
        // When
        boolean actual = Task4.isPassword("");
        // Then
        assertFalse(actual);
    }

}
