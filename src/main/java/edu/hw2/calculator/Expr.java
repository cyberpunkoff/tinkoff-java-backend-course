package edu.hw2.calculator;

public sealed interface Expr permits Constant, Negate, Addition, Multiplication, Exponent {
    double evaluate();
}
