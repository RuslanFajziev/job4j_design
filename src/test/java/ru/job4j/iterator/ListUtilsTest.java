package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void removeFilterInteger() {
        Predicate<Integer> predicate = x -> x < 1;
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, -5, 25, -7));
        ListUtils.removeIf(input, predicate);
        assertThat(Arrays.asList(1, 2, 3, 25), Is.is(input));
    }

    @Test
    public void removeFilterString() {
        Predicate<String> predicate = x -> x.equals("bc") || x.equals("cbbb");
        List<String> input = new ArrayList<>(Arrays.asList("abc", "bc", "cbbb", "abc"));
        ListUtils.removeIf(input, predicate);
        assertThat(Arrays.asList("abc", "abc"), Is.is(input));
    }

    @Test
    public void replaceFilterString() {
        Predicate<String> predicate = x -> x.equals("abc");
        List<String> input = new ArrayList<>(Arrays.asList("abc", "bc", "cbbb", "abc"));
        ListUtils.replaceIf(input, predicate, "ЗАМЕНА");
        assertThat(Arrays.asList("ЗАМЕНА", "bc", "cbbb", "ЗАМЕНА"), Is.is(input));
    }

    @Test
    public void removeAllFilterString() {
        List<String> input = new ArrayList<>(Arrays.asList("abc", "bc", "cbbb", "abc"));
        List<String> inputFilter = new ArrayList<>(Arrays.asList("bc", "cbbb"));
        ListUtils.removeAll(input, inputFilter);
        assertThat(Arrays.asList("abc", "abc"), Is.is(input));
    }

    @Test
    public void removeAllFilterInteger() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 20, 40, 3, 50, 4, 60, 5));
        List<Integer> inputFilter = new ArrayList<>(Arrays.asList(20, 40, 50, 60));
        ListUtils.removeAll(input, inputFilter);
        assertThat(Arrays.asList(1, 2, 3, 4, 5), Is.is(input));
    }
}