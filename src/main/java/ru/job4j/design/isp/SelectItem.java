package ru.job4j.design.isp;

public class SelectItem implements UserAction {
    private final Output out;

    public SelectItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Select item by name ===";
    }

    @Override
    public boolean execute(Input input, MemStore rootStore, MemStore currentStore) {
        String name = input.askStr("Enter name: ");
        boolean result = FindItem.find(name, rootStore.getLst());
        if (result) {
            currentStore.setLst(FindItem.getLst());
            currentStore.setLevel(FindItem.getLst().get(FindItem.getIndex()).getLevel());
            currentStore.setCurrentId(FindItem.getIndex());
            out.println("Select item successful. name: " + FindItem.getLst().get(FindItem.getIndex()).getName() + " index: " + FindItem.getIndex());
        } else {
            out.println("== Select item ERROR!!!!! ==");
        }
        return true;
    }
}