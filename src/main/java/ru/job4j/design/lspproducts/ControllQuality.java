package ru.job4j.design.lspproducts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    List<ProductStore> store = new ArrayList<>();

    public ControllQuality(List<ProductStore> store) {
        this.store = store;
    }

    public void distribute(Food food) {
        for (var elmStore : store) {
            if (elmStore.accept(food)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        List<ProductStore> lst = List.of(new Shop(), new Trash(), new Warehouse());
        ControllQuality controllQuality = new ControllQuality(lst);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Milk milk = new Milk("Сухое молоко", dateFormat.parse("11.10.2021"), dateFormat.parse("01.09.2021"), 50, 1);
            Apples apples = new Apples("Яблоки сезоные", dateFormat.parse("10.12.2021"), dateFormat.parse("01.09.2021"), 80, 5);
            Cheese cheese = new Cheese("Сыр янтарный", dateFormat.parse("25.09.2021"), dateFormat.parse("01.09.2021"), 23, 0);
            controllQuality.distribute(milk);
            controllQuality.distribute(apples);
            controllQuality.distribute(cheese);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
