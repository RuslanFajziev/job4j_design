package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(int id, T model) {
        mem.add(id, model);
        return mem.contains(model);
    }

    @Override
    public boolean delete(int id) {
        T model = mem.get(id);
        mem.remove(id);
        return mem.contains(model);
    }

    @Override
    public T findById(int id) {
        return mem.get(id);
    }
}