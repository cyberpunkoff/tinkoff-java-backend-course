package edu.hw2.calculator;

public record Exponent(Expr a, int power) implements Expr {
    @Override
    public double evaluate() {
        return Math.pow(a.evaluate(), power);
    }
}
