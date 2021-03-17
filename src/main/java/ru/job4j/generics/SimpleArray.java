package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterator<Object> {
    private Object[] data;
    private int size;
    private int row = 0;

    public SimpleArray(int sizeArray) {
        if (sizeArray <= 0) {
            throw new IllegalArgumentException();
        }
        data = new Object[sizeArray];
        size = data.length;
    }

    @Override
    public boolean hasNext() {
        return row < data.length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row++];
    }

    @Override
    public void remove() {
        remove(row--);
    }

    public Object[] getData() {
        return data;
    }

    public int getSize() {
        return size;
    }

    public int getRow() {
        return row;
    }

    public void printArray() {
        for (var ell : data) {
            System.out.println(ell);
        }

    }

    public void add(T model) {
        int index = indexForAdd();
        if (index >= 0) {
            data[index] = model;
        } else {
            System.out.println("No space available to add item");
        }
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[size - 1] = null;
    }

    public Object get(int index) {
        Objects.checkIndex(index, size);
        return data[index];
    }

    public int indexForAdd() {
        for (int i = 0; i < size; i++) {
            if (data[i] == null) {
                return i;
            }
        }
        return -1;
    }
}