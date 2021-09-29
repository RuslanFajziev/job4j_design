package ru.job4j.design.isp;

import java.util.List;

public class ShowAll implements UserAction {
    private final Output out;

    public ShowAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, MemStore memStore) {
        List<Item> lst = memStore.getLst();
        for (var item : lst) {
            out.println(item.getName() + " " + item.getRootId());
        }
        return true;
    }
}