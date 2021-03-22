package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator2<T> implements Iterator<Object> {
    private Object[] container;
    private int size;
    private int row;
    private int count;
    private int changesCont;

    public void setContainer(Object[] container) {
        this.container = container;
        this.row = 0;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCount(int count) {
        this.count = count;
        this.changesCont = count;
    }

    public void setChangesCont(int changesCont) {
        this.changesCont = changesCont;
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
        if (count != changesCont) {
            throw new ConcurrentModificationException();
        }
        return container[row++];
    }
}
