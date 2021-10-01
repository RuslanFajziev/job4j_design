package ru.job4j.design.isp;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private List<Item> lst = new ArrayList<>();
    private String name;
    private int level;

    public Item(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Item> getLst() {
        return lst;
    }
}