package ru.job4j.design.isp;

import java.util.List;

public class FindItem {
    private static int index;
    private static List<Item> lst;

    public static int getIndex() {
        return index;
    }

    public static List<Item> getLst() {
        return lst;
    }

    public static boolean find(String nameItem, MemStore rootStore, MemStore currentStore) {
        List<Item> newCurrentList = rootStore.getLst();
        boolean rsl = false;
        for (var elm : newCurrentList) {
            if (elm.getName().equals(nameItem)) {
                index = newCurrentList.indexOf(elm);
                lst = newCurrentList;
                currentStore.setLst(newCurrentList);
                rsl = true;
                break;
            } else if (!elm.getName().equals(nameItem) && !elm.getLst().isEmpty()) {
                currentStore.setLst(newCurrentList);
                find(nameItem, rootStore, currentStore);
            }
        }
        return rsl;
    }
}