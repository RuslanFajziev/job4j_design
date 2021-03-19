package ru.job4j.generics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    SimpleArray simpleArray = new SimpleArray(7);

    @Before
    public void setUp() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.add(6);
        simpleArray.add(7);
    }

    @Test
    public void remove() {
        simpleArray.remove(3);
        assertThat(simpleArray.get(3), is(5));
        assertThat(simpleArray.get(5), is(7));
    }

    @Test
    public void removeAdd() {
        simpleArray.set(1, null);
        simpleArray.add(999);
        simpleArray.set(3, null);
        simpleArray.add(555);
        assertThat(simpleArray.get(1), is(999));
        assertThat(simpleArray.get(3), is(555));
    }

    @Test
    public void set() {
        simpleArray.set(6, "stringMY");
        assertThat(simpleArray.get(6), is("stringMY"));
    }

    @Test
    public void iteratorTest() {
        assertThat(simpleArray.iterator().next(), is(1));
        assertThat(simpleArray.iterator().next(), is(2));
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        assertThat(simpleArray.iterator().next(), is(7));
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorTest2() {
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        simpleArray.iterator().next();
    }

    @Test
    public void iteratorTest3() {
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        simpleArray.iterator().next();
        assertFalse(simpleArray.iterator().hasNext());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setTest() {
        simpleArray.set(7, "fdfdf");
    }

    @Test
    public void add() {
        simpleArray.remove(3);
        simpleArray.add(999);
        assertThat(simpleArray.get(3), is(5));
        assertThat(simpleArray.get(6), is(999));
    }
}