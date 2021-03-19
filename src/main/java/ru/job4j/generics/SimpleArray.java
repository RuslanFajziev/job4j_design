package ru.job4j.generics;

import java.util.Iterator;

import static java.util.Objects.checkIndex;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] data;
    private SimpleArrayIterator simpleArrayIterator = new SimpleArrayIterator();
    private int size = 0;

    public SimpleArray(int sizeArray) {
        if (sizeArray <= 0) {
            throw new IllegalArgumentException();
        }
        data = new Object[sizeArray];
    }

    @Override
    public Iterator<T> iterator() {
        simpleArrayIterator.setData(data);
        return simpleArrayIterator;
    }

    public void add(T model) {
        int index = indexForAdd();
        if (index >= 0) {
            data[index] = model;
            ++size;
        } else {
            System.out.println("No space available to add item");
        }
    }

    public void set(int index, T model) {
        checkIndex(index, size);
        data[index] = model;
    }

    public void remove(int index) {
        checkIndex(index, size);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
     }

    public Object get(int index) {
        checkIndex(index, size);
        return data[index];
    }

    public int indexForAdd() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                return i;
            }
        }
        return -1;
    }
}