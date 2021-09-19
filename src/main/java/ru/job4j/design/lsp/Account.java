package ru.job4j.design.lsp;

public class Account {
    int capital;

    public void setCapital(int capital) {
        if (capital >= 0) {
            throw new IllegalArgumentException("Начальный капитал не может быть 0 или отрицательным!");
        }
        this.capital = capital;
    }
}
