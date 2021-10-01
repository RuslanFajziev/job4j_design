package ru.job4j.design.isp;

import java.util.List;

public class ShowAll implements UserAction {
    private final Output out;

    public ShowAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show tree menu ===";
    }

    @Override
    public boolean execute(Input input, MemStore rootStore, MemStore currentStore) {
        recursionPrint(rootStore.getLst());
        return true;
    }

    private void recursionPrint(List<Item> currentList) {
        for (var elm : currentList) {
            String delimiter = "-".repeat(elm.getLevel());
            out.println(delimiter + " " + elm.getName());
            if (!elm.getLst().isEmpty()) {
                recursionPrint(elm.getLst());
            }
        }
    }
}