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
        int typeAdd = input.askInt("Enter 1 - primary, 2 - child elements: ");
        int level = currentStore.getLevel();
        if (typeAdd == 1) {
            String name = input.askStr("Enter name: ");
            Item item = new Item(name, level);
            currentStore.add(item);
            currentStore.setCurrentId(currentStore.getCurrentId() + 1);
        } else if (typeAdd == 2) {
            var lstCurrent = currentStore.getLst();
            if (lstCurrent.isEmpty()) {
                out.println("Empty list menu. Enter 1 only");
                return true;
            }
            String name = input.askStr("Enter name: ");
            Item item = new Item(name, level + 1);
            int index = currentStore.getCurrentId();
            if (index < 0) {
                out.println("Index current < 0!");
                return true;
            }
            List<Item> newCurrentList = lstCurrent.get(index).getLst();
            newCurrentList.add(item);
            int newCurrentId = newCurrentList.indexOf(item);
            currentStore.setCurrentId(newCurrentId);
            currentStore.setLst(newCurrentList);
            currentStore.setLevel(level + 1);
        } else {
            out.println("ENTER 1 or 2");
        }
        return true;
    }
}