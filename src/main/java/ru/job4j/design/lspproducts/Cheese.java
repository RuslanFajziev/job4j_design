package ru.job4j.design.lspproducts;

import java.util.Date;

public class Cheese extends Food {
    public Cheese(String name, Date expiryDate, Date createDate, int price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}