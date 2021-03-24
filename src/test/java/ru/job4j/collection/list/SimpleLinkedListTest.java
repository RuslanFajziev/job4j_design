package ru.job4j.collection.list;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.*;

public class SimpleLinkedListTest {

    @Test
    public void whenAddAndGet() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        assertThat(list.get(0), Is.is(1));
        assertThat(list.get(1), Is.is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetFromOutOfBoundThenExceptionThrown() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.get(2);
    }

    @Test
    public void whenGetIteratorTwiceThenEveryFromBegin() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);

        Iterator<Integer> first = list.iterator();
        assertThat(first.hasNext(), Is.is(true));
        assertThat(first.next(), Is.is(1));
        assertThat(first.hasNext(), Is.is(true));
        assertThat(first.next(), Is.is(2));
        assertThat(first.hasNext(), Is.is(false));

        Iterator<Integer> second = list.iterator();
        assertThat(second.hasNext(), Is.is(true));
        assertThat(second.next(), Is.is(1));
        assertThat(second.hasNext(), Is.is(true));
        assertThat(second.next(), Is.is(2));
        assertThat(second.hasNext(), Is.is(false));
    }

    @Test
    public void test() {
        List<Object> list = new SimpleLinkedList<>();
        List<String> list2 = new SimpleLinkedList<>();
        list.add("1");
        list.add(2);
        list2.add("Test");
        list.add(list2);
        assertThat(list.get(2), Is.is(list2));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void test2() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), Is.is(true));
        assertThat(iterator.next(), Is.is(1));
        assertThat(iterator.hasNext(), Is.is(true));
        assertThat(iterator.next(), Is.is(2));
        list.add(3);
        iterator.hasNext();
    }

}