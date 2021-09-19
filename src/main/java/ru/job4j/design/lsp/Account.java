package ru.job4j.design.lsp;

public class Account {
    int capital;
    int result;

    public void setCapital(int capital) {
        if (capital <= 0) {
            throw new IllegalArgumentException("Начальный капитал не может быть 0 или отрицательным!");
        }
        this.capital = capital;
    }

    public int getResult() {
        result = this.capital / 2;
        if (result == 50) {
            throw new IllegalArgumentException("куыгде не должен ровняться 50");
        }
        return result;
    }
}
