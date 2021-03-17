package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    public int checkId(String id) {
        int rsl = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    @Override
    public boolean replace(String id, T model) {
        boolean rsl = false;
        int i = checkId(id);
        if (i != -1) {
            mem.set(i, model);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        int i = checkId(id);
        if (i != -1) {
            mem.remove(i);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        int i = checkId(id);
        if (i != -1) {
            return mem.get(i);
        }
        return null;
    }
}