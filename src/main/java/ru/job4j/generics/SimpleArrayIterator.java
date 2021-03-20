package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator<T> implements Iterator<Object> {
    private int row = 0;
    private int size = 0;
    private Object[] data;

    public void setData(Object[] data) {
        this.data = data;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public boolean hasNext() {
        return row < size;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row++];
    }
}
