package ru.job4j.design.dip;

import java.util.List;

public class Student {
    String name;
    String lastName;
    List<Courses> stores;

    public Student(String name, String lastName, List<Courses> stores) {
        this.name = name;
        this.lastName = lastName;
        this.stores = stores;
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

    public List<Courses> getStores() {
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