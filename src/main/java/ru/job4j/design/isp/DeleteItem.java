package ru.job4j.design.isp;

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
        currentStore.setLst(rootStore.getLst());
        String name = input.askStr("Enter name for delete: ");
        boolean result = FindItem.find(name, rootStore, currentStore);
        if (result) {
            currentStore.getLst().remove(FindItem.getIndex());
            out.println("Delete successful");
        } else {
            out.println("== Delete ERROR!!!!! ==");
        }
        return true;
    }
}