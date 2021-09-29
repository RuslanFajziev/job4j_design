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
    public boolean execute(Input input, MemStore memStore) {
        String name = input.askStr("Enter name: ");
        int result = memStore.select(name);
        if (result != -1) {
            out.println("Select item successful");
        } else {
            out.println("== Select item ERROR!!!!! ==");
        }
        return true;
    }
}