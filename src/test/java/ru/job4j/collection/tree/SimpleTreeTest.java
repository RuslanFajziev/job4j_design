package ru.job4j.collection.tree;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class SimpleTreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void test3() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertFalse(tree.add(7, 9));
        assertTrue(tree.add(5, 7));
        assertFalse(tree.add(5, 7));
    }

    @Test
    public void testBinaryTrue() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 4);
        tree.add(3, 5);
        tree.add(5, 6);
        tree.add(5, 7);
        assertTrue(tree.isBinary());
    }

    @Test
    public void testBinaryFalse() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 1);
        tree.add(1, 2);
        tree.add(2, 3);
        tree.add(2, 4);
        tree.add(3, 5);
        tree.add(3, 6);
        tree.add(4, 7);
        tree.add(4, 8);
        tree.add(5, 9);
        tree.add(5, 10);
        tree.add(5, 11);
        assertFalse(tree.isBinary());
    }
}