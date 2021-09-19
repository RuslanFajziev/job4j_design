package ru.job4j.design.lsp;

public class Account {
    int capital;
    public Account(int capital) {
        if (capital > 50) {
            throw new IllegalArgumentException("capital не может быть > 50");
        }
        this.capital = capital;
    }
}
