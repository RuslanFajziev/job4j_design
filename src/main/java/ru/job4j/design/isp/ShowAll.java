package ru.job4j.design.isp;

import java.util.List;

public class ShowAll implements UserAction {
    private final Output out;

    public ShowAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, MemStore rootStore, MemStore currentStore) {
        recursionPrint(rootStore, currentStore);
        return true;
    }

    private void recursionPrint(MemStore rootStore, MemStore currentStore) {
        List<Item> newCurrentList = rootStore.getLst();
        for (var elm : newCurrentList) {
            print(elm);
            if (!elm.getLst().isEmpty()) {
                currentStore.setLst(elm.getLst());
            }
        }
    }


    private void print(Item item) {
        String delimiter = "-".repeat(item.getLevel());
        out.println(delimiter + " " + item.getName());
//        private static void printMenu(Element root, int level) {
//            String delimiter = "-".repeat(level);
//            System.out.println(delimiter + " " + root.getName());
//            for (Element subItem : root.getChildren()) {
//                printMenu(subItem, level + 1);
//            }
//        }
    }
}