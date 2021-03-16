package ru.job4j.generics;

public abstract class Base {
    private final int id;

    public Base(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}