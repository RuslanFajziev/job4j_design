package ru.job4j.design.srp;

import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class ReportJson implements ReportString {
    private Store store;

    public ReportJson(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        var lib = new GsonBuilder().create();
        text.append(lib.toJson(store.findBy(filter)));
        return text.toString();
    }
}