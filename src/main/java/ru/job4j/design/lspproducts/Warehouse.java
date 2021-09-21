package ru.job4j.design.lspproducts;

import java.util.Calendar;
import java.util.HashSet;

public class Warehouse implements ProductStore {
    HashSet<Food> store = new HashSet<>();

    @Override
    public boolean accept(Food food) {
        double percentNow = CheckPercentUnit.check(food.getExpiryDate(), food.getCreateDate(), Calendar.getInstance().getTime());
        if (percentNow < 25) {
            return store.add(food);
        }
        return false;
    }
}