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
        // given
        List<LocalDate> expected =
            List.of(LocalDate.parse("1925-02-13"), LocalDate.parse("1925-03-13"), LocalDate.parse("1925-11-13"));
        // when
        List<LocalDate> actual = Task2.collectFriday13(1925);

        // then
        assertEquals(expected, actual);

        // given
        expected = List.of(LocalDate.parse("2024-09-13"), LocalDate.parse("2024-12-13"));
        // when
        actual = Task2.collectFriday13(2024);
        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Некорректный ввод")
    void invalidInput() {
        // expect
        assertThrows(IllegalArgumentException.class, () -> Task2.collectFriday13(null));

    }

    @Test
    @DisplayName("Проверка ближайшей пятницы13 если такая есть")
    void isValidClosest() {
        // given
        LocalDate expected = LocalDate.parse("1925-11-13");
        // when
        LocalDate actual = Task2.closestFriday13(LocalDate.of(1925, 9, 10));
        // then
        assertEquals(expected, actual);

        // given
        expected = LocalDate.parse("1925-02-13");
        // when
        actual = Task2.closestFriday13(LocalDate.of(1924, 12, 30));
        // then
        assertEquals(expected, actual);
    }

}
