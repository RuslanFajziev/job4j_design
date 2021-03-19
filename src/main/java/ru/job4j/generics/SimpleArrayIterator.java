package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator<T> implements Iterator<Object> {
    private int row = 0;
    private Object[] data;

    public void setData(Object[] data) {
        this.data = data;
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
}
