package ru.job4j.design.lspproducts;

import java.util.HashSet;

public interface ProductStore {
    boolean accept(Food food);
    HashSet<Food> getStore();
    void setStore(HashSet<Food> newStore);
    void clearStore();
}