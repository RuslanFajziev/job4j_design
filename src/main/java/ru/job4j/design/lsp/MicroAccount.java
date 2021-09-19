package ru.job4j.design.lsp;

public class MicroAccount extends Account {
    @Override
    public void setCapital(int capital) {
        if (capital >= 0) {
            throw new IllegalArgumentException("Начальный капитал не может быть 0 или отрицательным!");
        } else if (capital > 100) {
            throw new IllegalArgumentException("Начальный капитал не может быть более 100");
        }
        this.capital = capital;
    }
}