package ru.job4j.generics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    SimpleArray simpleArray = new SimpleArray(7);
    Iterator iterator = simpleArray.iterator();

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
        assertThat(simpleArray.get(1), is((Object) null));
        assertThat(simpleArray.get(3), is((Object) null));
    }

    @Test
    public void set() {
        simpleArray.set(6, "stringMY");
        assertThat(simpleArray.get(6), is("stringMY"));
    }

    @Test
    public void iteratorTest() {
        Iterator iterator = simpleArray.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertThat(iterator.next(), is(7));
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorTest2() {
        Iterator iterator = simpleArray.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test
    public void iteratorTest3() {
        Iterator iterator = simpleArray.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
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

    @Test(expected = NoSuchElementException.class)
    public void iteratorTest4() {
        simpleArray.remove(0);
        simpleArray.remove(0);
        simpleArray.remove(0);
        Iterator iterator = simpleArray.iterator();
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.next(), is(7));
        iterator.next();
    }

    @Test
    public void iteratorTest5() {
        Iterator iterator = simpleArray.iterator();
        assertThat(iterator.next(), is(1));
        Iterator iterator1 = simpleArray.iterator();
        assertThat(iterator1.next(), is(1));
    }

}