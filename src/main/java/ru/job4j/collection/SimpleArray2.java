package ru.job4j.collection;

import java.util.Iterator;

import static java.util.Objects.checkIndex;

public class SimpleArray2<T> implements Iterable<T> {
    private Object[] container;
    private SimpleArrayIterator2 simpleArrayIterator2 = new SimpleArrayIterator2();
    private int sizeArray;
    private int size = 0;
    private int changesCont;

    public SimpleArray2(int sizeArray) {
        if (sizeArray <= 0) {
            throw new IllegalArgumentException();
        }
        container = new Object[sizeArray];
        this.sizeArray = sizeArray;
        this.changesCont = 0;
    }

    public SimpleArray2() {
        this.sizeArray = 10;
        container = new Object[sizeArray];
        this.changesCont = 0;
    }

    public Object get(int index) {
        checkIndex(index, size);
        return container[index];
    }

    public void add(T model) {
        if (size == container.length) {
            container = grow();
        }
        container[size++] = model;
        simpleArrayIterator2.setChangesCont(++changesCont);
    }

    public Object[] grow() {
        Object[] newContainer = new Object[container.length + sizeArray];
        System.arraycopy(container, 0, newContainer, 0, size);
        return newContainer;
    }

    @Override
    public Iterator<T> iterator() {
        simpleArrayIterator2.setContainer(container);
        simpleArrayIterator2.setSize(size);
        simpleArrayIterator2.setCount(changesCont);
        return simpleArrayIterator2;
    }
}