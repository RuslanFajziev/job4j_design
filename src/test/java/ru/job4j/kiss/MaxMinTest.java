package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {
    private List<Integer> listInt = List.of(1, 2, 5, 4, 3, 6, 7, 9, 10, 8);
    private List<String> listStr = List.of("a", "dddd", "bb", "ccc");
    MaxMin maxMin = new MaxMin();

    @Test
    public void testMaxInt() {
        Comparator<Integer> comparatorMaxInt = (x, y) -> Integer.compare(x, y);
        int maxElm = maxMin.max(listInt, comparatorMaxInt);
        assertThat(10, is(maxElm));
    }

    @Test
    public void testMinInt() {
        Comparator<Integer> comparatorMinInt = (x, y) -> Integer.compare(y, x);
        int minElm = maxMin.min(listInt, comparatorMinInt);
        assertThat(1, is(minElm));
    }

    @Test
    public void testMaxStr() {
        Comparator<String> comparatorMaxStr = (x, y) -> Integer.compare(x.length(), y.length());
        String maxStr = maxMin.max(listStr, comparatorMaxStr);
        assertThat("dddd", is(maxStr));
    }

    @Test
    public void testMinStr() {
        Comparator<String> comparatorMinStr = (x, y) -> Integer.compare(y.length(), x.length());
        String minStr = maxMin.min(listStr, comparatorMinStr);
        assertThat("a", is(minStr));
    }

}