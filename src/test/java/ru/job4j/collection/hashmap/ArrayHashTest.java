package ru.job4j.collection.hashmap;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ArrayHashTest {
    @Test
    public void test1() {
        ArrayHash arrayHash = new ArrayHash();
        arrayHash.insert("Vasia", 1);
        arrayHash.insert("Vasia", 2);
        assertFalse(arrayHash.insert("Vasia", 2));
        assertThat(arrayHash.get("Vasia"), is(1));
    }

    @Test
    public void test2() {
        ArrayHash arrayHash = new ArrayHash();
        arrayHash.insert(1, 1);
        arrayHash.insert(2, 2);
        arrayHash.insert(3, 3);
        arrayHash.insert(4, 4);
        arrayHash.insert(5, 5);
        arrayHash.insert(6, 6);
        arrayHash.insert(7, 7);
        arrayHash.insert(8, 8);
        arrayHash.insert(9, 9);
        arrayHash.insert(10, 10);
        assertThat(arrayHash.get("Vasia"), is((Object) null));
        assertThat(arrayHash.get(8), is(8));
        assertThat(arrayHash.get(10), is(10));
        assertThat(arrayHash.get(9), is(9));
        assertThat(arrayHash.get(7), is(7));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void test3() {
        ArrayHash arrayHash = new ArrayHash();
        arrayHash.insert(7, 7);
        arrayHash.insert(8, 8);
        Iterator<ArrayHash.NodeHashMap> iterator = arrayHash.iterator();
        iterator.hasNext();
        arrayHash.insert(9, 9);
        iterator.hasNext();
    }

    @Test
    public void test4() {
        ArrayHash arrayHash = new ArrayHash();
        arrayHash.insert(7, 7);
        arrayHash.insert(8, 8);
        arrayHash.insert(9, 9);
        arrayHash.insert(10, 10);

        Iterator<ArrayHash.NodeHashMap> iterator = arrayHash.iterator();
        iterator.hasNext();
        assertThat(iterator.next().getValue(), is(9));
        iterator.hasNext();
        assertThat(iterator.next().getValue(), is(10));
        iterator.hasNext();
        assertThat(iterator.next().getValue(), is(7));
        iterator.hasNext();
        assertThat(iterator.next().getValue(), is(8));
        assertFalse(iterator.hasNext());
        assertFalse(iterator.hasNext());
        assertFalse(iterator.hasNext());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void test5() {
        ArrayHash arrayHash = new ArrayHash();
        arrayHash.insert(1, 1);
        arrayHash.insert(2, 2);
        arrayHash.insert(3, 3);
        arrayHash.insert(4, 4);
        arrayHash.insert(5, 5);
        arrayHash.insert(6, 6);
        arrayHash.insert(7, 7);
        arrayHash.insert(8, 8);
        arrayHash.insert(9, 9);
        arrayHash.insert(10, 10);
        assertFalse(arrayHash.insert(10, 10));
        assertFalse(arrayHash.insert(8, 8));
        assertTrue(arrayHash.insert(11, 11));
        assertTrue(arrayHash.insert(12, 12));
        assertThat(arrayHash.size(), is(12));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void test6() {
        ArrayHash arrayHash = new ArrayHash();
        arrayHash.insert(7, 7);
        arrayHash.insert(8, 8);
        arrayHash.insert(9, 9);
        arrayHash.insert(10, 10);
        assertTrue(arrayHash.delete(10));
        assertFalse(arrayHash.delete(1));
        assertThat(arrayHash.size(), is(3));

        Iterator<ArrayHash.NodeHashMap> iterator = arrayHash.iterator();
        iterator.hasNext();
        assertThat(iterator.next().getValue(), is(9));
        iterator.hasNext();
        assertThat(iterator.next().getValue(), is(7));
        iterator.hasNext();
        assertThat(iterator.next().getValue(), is(8));
        assertTrue(arrayHash.insert(12, 12));
        iterator.hasNext();
    }

    @Test
    public void test7() {
        ArrayHash arrayHash = new ArrayHash();
        arrayHash.insert(1, 1);
        arrayHash.insert(2, 2);
        assertThat(arrayHash.size(), is(2));
        assertTrue(arrayHash.delete(1));
        assertThat(arrayHash.size(), is(1));
        assertFalse(arrayHash.delete(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void test8() {
        ArrayHash arrayHash = new ArrayHash();
        arrayHash.insert(7, 7);
        arrayHash.insert(8, 8);
        arrayHash.insert(9, 9);

        Iterator<ArrayHash.NodeHashMap> iterator = arrayHash.iterator();
        iterator.hasNext();
        assertThat(iterator.next().getValue(), is(9));
        iterator.hasNext();
        assertThat(iterator.next().getValue(), is(7));
        iterator.hasNext();
        assertThat(iterator.next().getValue(), is(8));
        iterator.next();
    }
}