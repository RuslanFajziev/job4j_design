package ru.job4j.design.isp;

import java.util.List;

public class AddItem implements UserAction {
    private final Output out;

    public AddItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Add new Item ===";
    }

    @Override
    public boolean execute(Input input, MemStore rootStore, MemStore currentStore) {
        currentStore.setLst(rootStore.getLst());
        int typeAdd = input.askInt("Enter 1 - primary, 2 - child elements: ");
        String name = input.askStr("Enter name: ");
        int level = currentStore.getLevel();
        if (typeAdd == 1) {
            Item item = new Item(name, level);
            currentStore.add(item);
        } else if (typeAdd == 2) {
            Item item = new Item(name, level + 1);
            int index = currentStore.getLst().size() - 1;
            List<Item> newCurrentList = currentStore.getLst().get(index).getLst();
            newCurrentList.add(item);
            currentStore.setLst(newCurrentList);
            currentStore.setLevel(level + 1);
        } else {
            throw new IllegalArgumentException("incorrect input");
        }
        return true;
    }
}