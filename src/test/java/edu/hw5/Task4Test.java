package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @ParameterizedTest
    @ValueSource(strings = {"~asdf~", "!asdf!", "@asdf@", "#asfd#", "$qwerty$",
        "%qwerty%", "^qwerty^", "&asds&", "*qwerty*", "|asdf|", "qwerty~ ! @ # $ % ^ & * |"})
    @DisplayName("Пароль содержит требуемые символы")
    void isValid(String strings) {
        boolean actual = Task4.isPassword(strings);
        assertTrue(actual);
    }

    @Test
    @DisplayName("Пароль не содержит необходимые символы")
    void isNotValid() {
        boolean actual = Task4.isPassword("abcde");
        assertFalse(actual);
    }

    @Test
    @DisplayName("Пароль пуст")
    void isNull() {
        boolean actual = Task4.isPassword("");
        assertFalse(actual);
    }

}
