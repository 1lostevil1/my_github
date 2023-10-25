package edu.hw2.task1;

public sealed interface Expr permits Expr.Addition, Expr.Constant, Expr.Exponent, Expr.Multiplication, Expr.Negate {
    double evaluate();

    public record Constant(double value) implements Expr {
        public double evaluate() {
            return value;
        }
    }

    public record Addition(Expr first, Expr second) implements Expr {
        public double evaluate() {
            return first.evaluate() + second.evaluate();
        }
    }

    public record Negate(Expr value) implements Expr {
        public double evaluate() {
            return (value.equals(0)) ? 0 : (-1) * value.evaluate();
        }
    }

    public record Multiplication(Expr first, Expr second) implements Expr {
        public double evaluate() {
            return first.evaluate() * second.evaluate();
        }
    }

    public record Exponent(Expr val, double exp) implements Expr {
        public double evaluate() {
            return Math.pow(val.evaluate(), exp);
        }

    }
}




