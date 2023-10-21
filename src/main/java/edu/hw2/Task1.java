package edu.hw2;

import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task1 {

    private final static double TWO = 2;
    private final static double FOUR = 4;
    private final static double ONE = 2;

        private Task1() {

        }

        private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

        public static void main(String[] args) {
            var two = new Expr.Constant(TWO);
            var four = new Expr.Constant(FOUR);
            var negOne = new Expr.Negate(new Expr.Constant(ONE));
            var sumTwoFour = new Expr.Addition(two, four);
            var mult = new Expr.Multiplication(sumTwoFour, negOne);
            var exp = new Expr.Exponent(mult, TWO);
            var res = new Expr.Addition(exp, new Expr.Constant(ONE));

            LOGGER.info(res + " = " + res.evaluate());

        }
    }

