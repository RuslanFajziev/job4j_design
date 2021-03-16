package ru.job4j.generics;

public class Role extends User {
    public Role(int id) {
        super(id);
    }

    @Override
    public int getId() {
        return super.getId();
    }
}
