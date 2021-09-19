package ru.job4j.design.lsp;

public class MicroAccount extends Account {
    public MicroAccount(int capital) {
        super(capital);
    }
    public void setCapital(int capital) {
        this.capital = capital;
    }
}