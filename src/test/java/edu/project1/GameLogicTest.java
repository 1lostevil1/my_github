package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    @Test
    @DisplayName("Пустая строка")
    void emptyStr() {
        GameLogic initialization = new GameLogic();
        boolean actual = initialization.start("");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Превышено количество попыток")
    void maxCount() {
        GameLogic initialization = new GameLogic("a\ny\ni\no\nf\nE");
        initialization.start("rect");
        String str=initialization.getOut();
        String actual = str.substring(str.length()-37,str.length()-28);
        String expected = "You lost!";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка что состояние игры при угадывании корректо изменяется")
    void guess() {
        GameLogic initialization = new GameLogic("r\ne\nc\nt\nE");
        initialization.start("rect");
        String str=initialization.getOut();
        String actual = str.substring(88,92);
        String expected = "Hit!";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка что состояние игры при не угадывании корректо изменяется")
    void notGuess() {
        GameLogic initialization = new GameLogic("y\nr\ne\nc\nt\nE");
        initialization.start("rect");
        String str=initialization.getOut();
        String actual = str.substring(88,115);
        String expected = "Missed, mistake 1 out of 5.";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка, что при отгадывании ввод строки длиной больше чем 1 (опечатка) приводит к повторному вводу")
    void wrongLetter() {
        GameLogic initialization = new GameLogic("ty\nr\ne\nc\nt\nE");
        initialization.start("rect");
        String str=initialization.getOut();
        String actual = str.substring(88,108);
        String expected = "Input correct letter";
        assertEquals(expected, actual);
    }
}
