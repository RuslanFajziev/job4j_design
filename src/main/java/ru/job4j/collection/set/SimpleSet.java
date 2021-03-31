package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArray2;

import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private SimpleArray2<T> set = new SimpleArray2<>();

    @Override
    public boolean add(T value) {
        if (!contains(value)) {
            set.add(value);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        Iterator<T> iter = iterator();
        while (iter.hasNext()) {
            if (value == null) {
                if (iter.next() == value) {
                    return true;
                }
            } else if (iter.next().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}