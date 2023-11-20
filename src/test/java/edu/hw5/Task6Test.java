package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    @Test
    @DisplayName("Является подпоследовательностью")
    void isValid() {
        // When
        boolean actual = Task6.isSubsequence("abc", "achfdbaabgacaabg");
        // Then
        assertTrue(actual);

    }

    @Test
    @DisplayName("Не является подпоследовательностью")
    void isNotValid() {
        // When
        boolean actual = Task6.isSubsequence("qwe", "achfdbaabgabcaabg");
        // Then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Не является подпоследовательностью")
    void isEmptyubsequence() {
        // When
        boolean actual = Task6.isSubsequence("", "achfdbaabgabcaabg");
        // Then
        assertTrue(actual);

    }

    @Test
    @DisplayName("Null")
    void nullStr() {
        // When
        boolean actual = Task6.isSubsequence(null, "achfdbaabgabcaabg");
        // Then
        assertFalse(actual);

    }
}
