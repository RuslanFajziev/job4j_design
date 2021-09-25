package ru.job4j.design.dip;

public class Book {
    String text;
    ConsolePrinter printer;
}

class ConsolePrinter {
    public void print(String text) {
        System.out.println(text);
    }
}