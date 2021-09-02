package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        var maxElm = value.get(0);
        for (var elm : value) {
            maxElm = check(comparator, maxElm, elm);
        }
        return maxElm;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        var minElm = value.get(0);
        for (var elm : value) {
            minElm = check(comparator, minElm, elm);
        }
        return minElm;
    }

    public <T> T check(Comparator<T> comparator, T valueLeft, T valueRight) {
        var resault = comparator.compare(valueLeft, valueRight);
        return resault == 1 ? valueLeft : valueRight;
    }
}