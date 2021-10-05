package ru.job4j.design.lspproducts;

import java.util.Calendar;
import java.util.HashSet;

public class Trash implements ProductStore {
    private HashSet<Food> store = new HashSet<>();

    @Override
    public HashSet<Food> getStore() {
        return store;
    }

    @Override
    public void setStore(HashSet<Food> newStore) {
        this.store = newStore;
    }

    @Override
    public void clearStore() {
        store.clear();
    }

    @Override
    public boolean accept(Food food) {
        double percentNow = CheckPercentUnit.check(food.getExpiryDate(), food.getCreateDate(), Calendar.getInstance().getTime());
        if (percentNow > 75) {
            return store.add(food);
        }
        return false;
    }
}