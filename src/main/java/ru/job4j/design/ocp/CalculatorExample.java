package ru.job4j.design.ocp;

import java.util.Random;

public class CalculatorExample {
    public int sumRondom(int a, int b) {
        Random random = new Random();
        return a + b + random.nextInt();
    }
}