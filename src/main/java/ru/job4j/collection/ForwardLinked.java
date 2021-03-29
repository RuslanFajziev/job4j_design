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
        if (head == null || head.next == null) {
            return false;
        }
        Node<T> nextRight;
        Node<T> nextLeft = null;
        Node<T> cursor = head;
        while (cursor != null) {
            nextRight = cursor.next;
            cursor.next = nextLeft;
            nextLeft = cursor;
            head = nextLeft;
            cursor = nextRight;
        }
        return true;
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