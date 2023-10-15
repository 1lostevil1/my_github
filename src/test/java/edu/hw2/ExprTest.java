package edu.hw2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ExprTest {
    @Test
    @DisplayName("метод constant")
    void test1() {
        double actual = new Expr.Constant(5).evaluate();
        double expected = 5.0;
        assertEquals(expected, actual);

        actual = new Expr.Constant(-10).evaluate();
        expected = -10.0;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("метод Addition")
    void test2() {
        double actual = new Expr.Addition(new Expr.Constant(7), new Expr.Constant(5)).evaluate();
        double expected = 12.0;
        assertEquals(expected, actual);

        actual = new Expr.Addition(new Expr.Constant(-5), new Expr.Constant(5)).evaluate();
        expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("метод Negate")
    void test3() {
        double actual = new Expr.Negate(new Expr.Constant(-5)).evaluate();
        double expected = 5.0;
        assertEquals(expected, actual);

        actual = new Expr.Negate(new Expr.Constant(0)).evaluate();
        expected = -0.0;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("метод Multiplication")
    void test4() {
        double actual = new Expr.Multiplication(new Expr.Constant(4), new Expr.Constant(2)).evaluate();
        double expected = 8.0;
        assertEquals(expected, actual);

        actual = new Expr.Multiplication(new Expr.Constant(-2), new Expr.Constant(2)).evaluate();
        expected = -4.0;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("метод  Exponent")
    void test5() {
        double actual = new Expr.Exponent(new Expr.Constant(4), 2).evaluate();
        double expected = 16.0;
        assertEquals(expected, actual);

        actual = new Expr.Exponent(new Expr.Constant(4), -1).evaluate();
        expected = 0.25;
        assertEquals(expected, actual);

        actual = new Expr.Exponent(new Expr.Constant(-5), 2).evaluate();
        expected = 25.0;
        assertEquals(expected, actual);

    }
}

