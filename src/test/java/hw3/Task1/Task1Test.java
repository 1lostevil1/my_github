package hw3.Task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    @DisplayName("проверка слова")
    void WordStringTest() {
        String actual = Task1.atbash("Hello");
        String expected = "Svool";
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("проверка ввода пустой строки")
    void EmptyStringTest() {
        String actual = Task1.atbash("");
        String expected = "";
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("предложение со знаками препинания и пробелами")
    void FullStringTest() {
        String actual = Task1.atbash(
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler");
        String expected =
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        assertEquals(actual, expected);
    }

}
