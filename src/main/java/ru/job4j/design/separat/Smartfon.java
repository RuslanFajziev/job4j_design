package ru.job4j.design.separat;

public class Smartfon implements Operation {
    @Override
    public double calculate() {
        return 2 + 3;
    }

    @Override
    public void photo() {
        System.out.println("Делаю фото, фейс попроще :)");
    }
}
