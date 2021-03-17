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
    public void size() {
        simpleArray.add(8);
        assertThat(simpleArray.getSize(), is(7));
    }

    @Test
    public void remove() {
        simpleArray.remove(6);
        assertThat(simpleArray.get(5), is(6));
        assertThat(simpleArray.getSize(), is(7));
        assertThat(simpleArray.get(6), is((Object) null));
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
        assertThat(simpleArray.next(), is(1));
        assertThat(simpleArray.next(), is(2));
        simpleArray.set(2, null);
        assertThat(simpleArray.next(), is((Object) null));
        assertThat(simpleArray.next(), is(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorTest2() {
        simpleArray.next();
        simpleArray.next();
        simpleArray.next();
        simpleArray.next();
        simpleArray.next();
        simpleArray.next();
        simpleArray.next();
        simpleArray.next();
    }

    @Test
    public void iteratorTest3() {
        simpleArray.next();
        simpleArray.next();
        simpleArray.next();
        simpleArray.remove();
        assertThat(simpleArray.getSize(), is(7));
        assertThat(simpleArray.getRow(), is(2));
        assertThat(simpleArray.get(simpleArray.getRow()), is(3));
        assertThat(simpleArray.next(), is(3));
        assertThat(simpleArray.next(), is(5));
    }
}