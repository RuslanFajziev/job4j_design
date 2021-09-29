package ru.job4j.design.isp;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private int rootId;
    private List<Item> lst = new ArrayList<>();
    private String name;

    public Item(int rootId, String name) {
        this.rootId = rootId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item(int rootId) {
        this.rootId = rootId;
    }

    public Item() {
    }

    public int getRootId() {
        return rootId;
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }

    public List<Item> getLst() {
        return lst;
    }
}