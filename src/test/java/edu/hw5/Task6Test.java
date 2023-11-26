package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    @Test
    @DisplayName("Является подпоследовательностью")
    void isValid() {
        // when
        boolean actual = Task6.isSubsequence("abc", "achfdbaabgacaabg");
        // then
        assertTrue(actual);

    }

    @Test
    @DisplayName("Не является подпоследовательностью")
    void isNotValid() {
        // when
        boolean actual = Task6.isSubsequence("qwe", "achfdbaabgabcaabg");
        // then
        assertFalse(actual);

    }

    @Test
    @DisplayName("Не является подпоследовательностью")
    void isEmptyubsequence() {
        // when
        boolean actual = Task6.isSubsequence("", "achfdbaabgabcaabg");
        // then
        assertTrue(actual);

    }

    @Test
    @DisplayName("Null")
    void nullStr() {
        // when
        boolean actual = Task6.isSubsequence(null, "achfdbaabgabcaabg");
        // then
        assertFalse(actual);

    }
}
