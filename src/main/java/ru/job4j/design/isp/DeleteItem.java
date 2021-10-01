package ru.job4j.design.isp;

import java.util.List;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, MemStore rootStore, MemStore currentStore) {
        String name = input.askStr("Enter name for delete: ");
        boolean result = FindItem.find(name, rootStore.getLst());
        if (result) {
            List<Item> newCurrentList = FindItem.getLst();
            int index = FindItem.getIndex();
            newCurrentList.remove(index);
            currentStore.setLst(newCurrentList);
            out.println("Delete successful");
        } else {
            out.println("== Delete ERROR!!!!! ==");
        }
        return true;
    }
}