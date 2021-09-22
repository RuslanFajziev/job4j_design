package ru.job4j.design.lspcars;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Garages> lst = new ArrayList<>();

    public Parking(List<Garages> lst) {
        this.lst = lst;
    }

    public List<Garages> getLst() {
        return lst;
    }

    public boolean find(Car car) {
        return false;
    }
}