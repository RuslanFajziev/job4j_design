package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
}