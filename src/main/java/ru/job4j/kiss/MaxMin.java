package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return check(value, comparator, true);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return check(value, comparator, false);
    }

    public <T> T check(List<T> value, Comparator<T> comparator, Boolean max) {
        int chkNumber;
        if (max) {
            chkNumber = 1;
        } else {
            chkNumber = -1;
        }
        var diffElm = value.get(0);
        for (var elm : value) {
            diffElm = comparator.compare(diffElm, elm) == chkNumber ? diffElm : elm;
        }
        return diffElm;
    }
}