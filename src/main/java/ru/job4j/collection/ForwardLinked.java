package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int marker = 0;
    private Node<T> markerHead;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void addBottomToTop(T value) {
        Node<T> node = new Node<T>(value, null);
        if (marker == 0) {
            Node<T> tail = head;
            node.next = tail;
            head = node;
            markerHead = node;
            marker = 1;
        } else if (marker == 1) {
            node.next = markerHead.next;
            markerHead = node;
            head.next = markerHead;
            marker = 2;
        } else if (marker > 1) {
            node.next = markerHead.next;
            Node<T> tail = node;
            markerHead.next = tail;
            markerHead = node;
        }
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> delNode = head;
        head = head.next;
        delNode.next = null;
        return delNode.value;
    }

    public T deleteLats() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> tail = head;
        Node<T> cursor = head;
        while (tail.next != null) {
            cursor = tail;
            tail = tail.next;
        }
        if (head.next == null) {
            head = null;
            return tail.value;
        } else {
            tail.next = null;
            cursor.next = null;
            return tail.value;
        }
    }

    public boolean revert() {
        boolean rsl = false;
        Node<T> tail = head;
        if (head == null) {
            return rsl;
        } else if (tail.next == null) {
            return rsl;
        }

        int counter = 1;
        rsl = true;
        while (tail.next != null) {
            tail = tail.next;
            counter++;
        }

        while (counter-- != 0) {
            T value = deleteLats();
            addBottomToTop(value);
        }
        marker = 0;
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}