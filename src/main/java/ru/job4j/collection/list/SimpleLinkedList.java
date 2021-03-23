package ru.job4j.collection.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Objects.checkIndex;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public SimpleLinkedList() {
        this.first = new Node<E>(null, null, null);
        this.last = new Node<E>(null, null, null);
        first.setNext(last);
        last.setPrev(first);
    }

    public int getSize() {
        return size;
    }

    @Override
    public void add(E value) {
        Node<E> current = last;
        current.setItem(value);
        last = new Node<E>(current, null, null);
        current.setNext(last);
        size++;
    }

    @Override
    public E get(int index) {
        checkIndex(index, size);
        Node<E> foundNode = first.getNext();
        for (int i = 0; i < index; i++) {
            foundNode = nextNode(foundNode);
        }
        return foundNode.getItem();
    }

    public Node<E> nextNode(Node<E> node) {
        return node.getNext();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < getSize();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(cursor++);
            }
        };
    }
}