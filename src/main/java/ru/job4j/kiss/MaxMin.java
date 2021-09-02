package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return check(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return check(value, comparator);
    }

    public <T> T check(List<T> value, Comparator<T> comparator) {
        var diffElm = value.get(0);
        for (var elm : value) {
            diffElm = comparator.compare(diffElm, elm) == 1 ? diffElm : elm;
        }
        return diffElm;
    }
}