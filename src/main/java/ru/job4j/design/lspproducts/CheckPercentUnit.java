package ru.job4j.design.lspproducts;

import java.util.Date;

public class CheckPercentUnit {
    public static double check(Date expiryDate, Date createDate, Date now) {
        double dayAll = (expiryDate.getTime() - createDate.getTime()) / (24 * 60 * 60 * 1000);
        double dayNow = (now.getTime() - createDate.getTime()) / (24 * 60 * 60 * 1000);
        return dayNow / (dayAll / 100);
    }
}