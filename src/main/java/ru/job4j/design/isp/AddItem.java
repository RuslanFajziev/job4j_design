package ru.job4j.design.isp;

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
    public boolean execute(Input input, MemStore memStore) {
        int typeAdd = input.askInt("Enter 1 - primary, 2 - child elements: ");
        String name = input.askStr("Enter name: ");
        int currentId = memStore.getCurrentId();
        if (typeAdd == 1) {
            Item item = new Item(0, name);
            memStore.add(item);
        } else if (typeAdd == 2) {
            memStore.getLst().get(currentId).getLst().add(new Item(currentId, name));
        } else {
            throw new IllegalArgumentException("incorrect input");
        }
        return true;
    }
}