package ru.job4j.design.separat;

public class Calculator implements Operation {
    @Override
    public double calculate() {
        return 2 + 2;
    }

    @Override
    public void photo() {
        throw new UnsupportedOperationException();
    }
}