package ru.job4j.generics;

public class User extends Base {

    public User(int id) {
        super(id);
    }

    @Override
    public int getId() {
        return super.getId();
    }
}
