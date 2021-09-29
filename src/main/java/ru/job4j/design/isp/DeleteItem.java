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
    public boolean execute(Input input, MemStore memStore) {
        String name = input.askStr("Enter name for delete: ");
        if (memStore.delete(name)) {
            out.println("Delete successful");
        } else {
            out.println("== Delete ERROR!!!!! ==");
        }
        return true;
    }
}