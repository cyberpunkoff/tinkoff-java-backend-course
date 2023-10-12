package edu.hw2.calculator;

public record Addition(Expr a, Expr b) implements Expr {
    @Override
    public double evaluate() {
        return a.evaluate() + b.evaluate();
    }
}
