package ru.job4j.design.lspproducts;

import java.util.Date;

public class Milk extends Food {
    public Milk(String name, Date expiryDate, Date createDate, int price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }

    public Milk(String name, Date expiryDate, Date createDate, int price, int discount, ProductStore productStore) {
        super(name, expiryDate, createDate, price, discount, productStore);
    }
}