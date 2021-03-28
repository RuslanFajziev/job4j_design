package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ForwardLinkedTest {

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.deleteFirst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.deleteFirst();
    }

    @Test
    public void whenMultiDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        assertThat(linked.deleteFirst(), is(1));
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenMultiDelete2() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        assertThat(linked.deleteFirst(), is(1));
        assertThat(linked.deleteFirst(), is(2));
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
    }

    @Test
    public void whenMultiDelete3() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        assertThat(linked.deleteFirst(), is(1));
        assertThat(linked.deleteLats(), is(3));
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenMultiDelete4() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        assertThat(linked.deleteFirst(), is(1));
        assertThat(linked.deleteLats(), is(4));
        assertThat(linked.deleteFirst(), is(2));
        assertThat(linked.deleteLats(), is(3));
        Iterator<Integer> it = linked.iterator();
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked2() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.deleteLats();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked3() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.deleteLats();
        linked.deleteLats();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked4() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.deleteLats();
        linked.deleteFirst();
        linked.deleteFirst();
    }

    @Test
    public void whenAddThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddAndRevertThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenSize0ThenReturnFalse() {
        ForwardLinked<Integer> emptyList = new ForwardLinked<>();
        assertFalse(emptyList.revert());
    }

    @Test
    public void whenSize1ThenReturnFalse() {
        ForwardLinked<Integer> singleList = new ForwardLinked<>();
        singleList.add(1);
        assertFalse(singleList.revert());
    }

    @Test
    public void whenAddAndRevertThenIter2() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test
    public void test1() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        linked.revert();
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
    }

    @Test
    public void test2() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        linked.revert();
        linked.deleteFirst();
        linked.deleteLats();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        linked.revert();
        linked.add(5);
        linked.revert();
        linked.add(1);
        linked.revert();
        Iterator<Integer> it2 = linked.iterator();
        assertThat(it2.next(), is(1));
        assertThat(it2.next(), is(2));
        assertThat(it2.next(), is(3));
        assertThat(it2.next(), is(4));
        assertThat(it2.next(), is(5));
    }
}