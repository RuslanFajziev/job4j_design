package ru.job4j.collection.hashmap;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

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
        assertThat(arrayHash.get(8), is((Object) 8));
        assertThat(arrayHash.get(10), is((Object) 10));
        assertThat(arrayHash.get(9), is((Object) 9));
        assertThat(arrayHash.get(7), is((Object) 7));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void test3() {
        ArrayHash arrayHash = new ArrayHash();
        arrayHash.insert(7, 7);
        arrayHash.insert(8, 8);
        Iterator iterator = arrayHash.iterator();
        iterator.hasNext();
        arrayHash.insert(9, 9);
        iterator.next();
    }

    @Test
    public void test4() {
        ArrayHash arrayHash = new ArrayHash();
        arrayHash.insert(7, 7);
        arrayHash.insert(8, 8);
        arrayHash.insert(9, 9);
        arrayHash.insert(10, 10);

        ArrayHash arrayHash2 = new ArrayHash();
        arrayHash2.insert(7, 7);
        arrayHash2.insert(8, 8);
        arrayHash2.insert(9, 9);
        arrayHash2.insert(10, 10);

        Iterator iterator = arrayHash.iterator();

        assertThat(iterator.next(), is(arrayHash2.get(9)));
        assertThat(iterator.next(), is(arrayHash2.get(10)));
        assertThat(iterator.next(), is(arrayHash2.get(7)));
        assertThat(iterator.next(), is(arrayHash2.get(8)));
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

        ArrayHash arrayHash2 = new ArrayHash();
        arrayHash2.insert(7, 7);
        arrayHash2.insert(8, 8);
        arrayHash2.insert(9, 9);

        Iterator iterator = arrayHash.iterator();
        assertThat(iterator.next(), is(arrayHash2.get(9)));
        assertThat(iterator.next(), is(arrayHash2.get(7)));
        assertThat(iterator.next(), is(arrayHash2.get(8)));

        Iterator iterator2 = arrayHash.iterator();
        assertThat(iterator2.next(), is(arrayHash2.get(9)));
        assertTrue(arrayHash.delete(8));
        iterator2.next();
    }
}