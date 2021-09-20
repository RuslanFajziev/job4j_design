package ru.job4j.design.lspproducts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllQuality {
    public static void main(String[] args) throws ParseException {
        List<Food> list = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        list.add(new Milk("Сухое молоко", dateFormat.parse("11.10.2021"), dateFormat.parse("01.09.2021"), 50, 1));
        list.add(new Apples("Яблоки сезоные", dateFormat.parse("10.12.2021"), dateFormat.parse("01.09.2021"), 80, 5));
        list.add(new Cheese("Сыр янтарный", dateFormat.parse("25.09.2021"), dateFormat.parse("01.09.2021"), 23, 0));
        Date now = dateFormat.parse("20.09.2021");

        ProductStore productStore = new Warehouse();
        for (var elm : list) {
            Date expiryDate = elm.getExpiryDate();
            Date createDate = elm.getCreateDate();
            double dayAll = (expiryDate.getTime() - createDate.getTime()) / (24 * 60 * 60 * 1000);
            double dayNow = (now.getTime() - createDate.getTime()) / (24 * 60 * 60 * 1000);
            double percentUnit = dayAll / 100;
            if (percentUnit > 0) {
                double percentNow = dayNow / percentUnit;
                if (percentNow >= 25 && percentNow <= 75) {
                    productStore = new Shop();
                    elm.setProductStore(productStore);
                } else if (percentNow > 75) {
                    productStore = new Trash();
                    elm.setProductStore(productStore);
                } else {
                    elm.setProductStore(productStore);
                }
            } else {
                throw new ArithmeticException("Деление на 0!");
            }
        }
    }
}
