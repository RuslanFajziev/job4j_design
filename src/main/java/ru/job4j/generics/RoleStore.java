package ru.job4j.generics;

public class RoleStore implements Store<Role> {
    private final Store<Role> store = new MemStore<>();

    @Override
    public void add(Role model) {
        store.add(model);
    }

    @Override
    public boolean replace(int id, Role model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(int id) {
        return store.delete(id);
    }

    @Override
    public Role findById(int id) {
        return store.findById(id);
    }
}
