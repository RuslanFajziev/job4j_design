package ru.job4j.design.isp;

import java.util.ArrayList;
import java.util.List;

public class MemStore {
    private List<Item> lst = new ArrayList<>();
    private int currentId = -1;
    private int level = 0;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Item> getLst() {
        return lst;
    }

    public void setLst(List<Item> lst) {
        this.lst = lst;
    }

    public int getCurrentId() {
        return currentId;
    }

    public void setCurrentId(int currentId) {
        this.currentId = currentId;
    }

    public void add(Item item) {
        lst.add(item);
    }
}