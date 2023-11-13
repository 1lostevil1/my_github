package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    @DisplayName("Корректный год")
    void validInput() {
        List<LocalDate> actual = Task2.isFriday13(1925);
        List<LocalDate> expected =
            List.of(LocalDate.parse("1925-02-13"), LocalDate.parse("1925-03-13"), LocalDate.parse("1925-11-13"));
        assertEquals(expected, actual);

        actual = Task2.isFriday13(2024);
        expected = List.of(LocalDate.parse("2024-09-13"), LocalDate.parse("2024-12-13"));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Некорректный ввод")
    void invalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Task2.isFriday13(null));

    }

    @Test
    @DisplayName("Проверка ближайшей пятницы13 если такая есть")
    void isValidClosest() {
        List<LocalDate> tmp = Task2.isFriday13(1925);
        LocalDate actual = Task2.closestFriday13(tmp, LocalDate.of(1925, 9, 10));
        LocalDate expected = LocalDate.parse("1925-11-13");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка ближайшей пятницы13 если такой нет")
    void isNotValidClosest() {
        List<LocalDate> tmp = Task2.isFriday13(1925);
        LocalDate actual = Task2.closestFriday13(tmp, LocalDate.of(1925, 12, 20));
        assertNull(actual);
    }
}
