package ru.job4j.design.lspproducts;
import java.util.Set;

public interface ProductStore {
    boolean accept(Food food);
    Set<Food> getStore();
    void setStore(Set<Food> newStore);
    void clearStore();
}