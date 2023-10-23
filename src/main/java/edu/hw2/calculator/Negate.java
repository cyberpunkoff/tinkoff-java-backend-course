package edu.hw2.calculator;

public record Negate(Expr a) implements Expr {
    @Override
    public double evaluate() {
        return -1 * a.evaluate();
    }
}
