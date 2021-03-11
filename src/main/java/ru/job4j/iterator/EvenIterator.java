package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;
    private int row = 0;

    public EvenIterator(int[] data) {
        this.data = data;
    }

    public boolean evenNumber(int number) {
        return number % 2 == 0;
    }

    public void indexData() {
        int lnData = data.length;
        while (row < lnData && !evenNumber(data[row])) {
            if (row + 1 < lnData) {
                row++;
                continue;
            }
            break;
        }
    }

    @Override
    public boolean hasNext() {
        if (row >= data.length) {
            return false;
        }
        indexData();
        boolean rsl = evenNumber(data[row]);
        row++;
        return rsl;
    }

    @Override
    public Integer next() {
        if (row >= data.length) {
            throw new NoSuchElementException();
        }
        indexData();
        if (!evenNumber(data[row]) || row >= data.length) {
            throw new NoSuchElementException();
        }
        Integer rsl = data[row];
        row++;
        return rsl;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        EvenIterator evenIterator = new EvenIterator(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(evenIterator.hasNext());

        System.out.println(evenIterator.next());
        System.out.println(evenIterator.next());
        System.out.println(evenIterator.next());

        System.out.println(evenIterator.hasNext());
        System.out.println(evenIterator.hasNext());

        System.out.println(evenIterator.next());


    }
}