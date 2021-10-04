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

    public static boolean find(String nameItem, List<Item> currentList) {
        for (var elm : currentList) {
            if (elm.getName().equals(nameItem)) {
                index = currentList.indexOf(elm);
                lst = currentList;
                return true;
            } else if (!elm.getName().equals(nameItem) && !elm.getLst().isEmpty()) {
                boolean rslRecursion = find(nameItem, elm.getLst());
                if (rslRecursion) {
                    return true;
                }
            }
        }
        return false;
    }
}