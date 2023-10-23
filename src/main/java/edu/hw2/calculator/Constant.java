package edu.hw2.calculator;

public record Constant(double n) implements Expr {
    @Override
    public double evaluate() {
        return n;
    }
}
