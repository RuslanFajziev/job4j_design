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
            var lstFind = FindItem.getLst();
            var itemFind = lstFind.get(FindItem.getIndex());
            var index = FindItem.getIndex();
            currentStore.setLst(lstFind);
            currentStore.setLevel(itemFind.getLevel());
            currentStore.setCurrentId(index);
            out.println("Select item successful. name: " + itemFind.getName() + " index: " + index);
        } else {
            out.println("== Select item ERROR!!!!! ==");
        }
        return true;
    }
}