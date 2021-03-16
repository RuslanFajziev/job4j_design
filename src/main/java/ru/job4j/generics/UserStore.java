package ru.job4j.generics;

public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        store.add(model);
    }

    @Override
    public boolean replace(int id, User model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(int id) {
        return store.delete(id);
    }

    @Override
    public User findById(int id) {
        return store.findById(id);
    }
}