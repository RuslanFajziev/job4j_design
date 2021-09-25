package ru.job4j.design.dip;

import java.util.HashMap;
import java.util.Map;

public class Student {
    String name;
    String lastName;
    Map<String, Courses> stores = new HashMap<>();

    public Student(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Map<String, Courses> getStores() {
        return stores;
    }
}

class Courses {
    String name;

    public Courses(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}