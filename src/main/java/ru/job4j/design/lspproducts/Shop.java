package ru.job4j.design.lspproducts;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Shop implements ProductStore {
    private Set<Food> store = new HashSet<>();

    @Override
    public Set<Food> getStore() {
        return store;
    }

    @Override
    public void setStore(Set<Food> newStore) {
        this.store = newStore;
    }

    @Override
    public void clearStore() {
        store.clear();
    }

    @Override
    public boolean accept(Food food) {
        double percentNow = CheckPercentUnit.check(food.getExpiryDate(), food.getCreateDate(), Calendar.getInstance().getTime());
        if (percentNow >= 25 && percentNow <= 75) {
            return store.add(food);
        }
        return false;
    }
}