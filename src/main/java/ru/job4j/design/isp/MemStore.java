package ru.job4j.design.isp;

import java.util.ArrayList;
import java.util.List;

public class MemStore {
    private List<Item> lst = new ArrayList<>();
    private int currentId = 0;

    public List<Item> getLst() {
        return lst;
    }

    public int getCurrentId() {
        return currentId;
    }

    public void setCurrentId(int currentId) {
        this.currentId = currentId;
    }

    public void add(Item item) {
        lst.add(item);
        int index = lst.indexOf(item);
        if (index != -1) {
            setCurrentId(index);
        }
    }

    public boolean delete(String name) {
        int index = findIndex(name);
        if (index != 1) {
            lst.remove(index);
            return true;
        }
        return false;
    }

    public int select(String name) {
        int index = findIndex(name);
        if (index != 1) {
            setCurrentId(index);
            return index;
        }
        return index;
    }

    public int findIndex(String name) {
        for (var item : lst) {
            if (item.getName().equals(name)) {
                int index = lst.indexOf(item);
                if (index != -1) {
                    return index;
                }
                break;
            }
        }
        return -1;
    }
}