package ru.job4j.design.lspproducts;

import java.util.Date;

public class Apples extends Food {
    public Apples(String name, Date expiryDate, Date createDate, int price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }

    public Apples(String name, Date expiryDate, Date createDate, int price, int discount, ProductStore productStore) {
        super(name, expiryDate, createDate, price, discount, productStore);
    }
}