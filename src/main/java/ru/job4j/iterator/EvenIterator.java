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

    public boolean checkNextElm(int rowIn) {
        boolean rsl = false;
        for (int rowArr = rowIn; rowArr < data.length; rowArr++) {
            if (data[rowArr] % 2 == 0) {
                rsl = true;
                row = rowArr + 1;
                break;
            }
        }
        return rsl;
    }

    @Override
    public boolean hasNext() {
        return checkNextElm(row);
//        return point < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        EvenIterator evenIterator = new EvenIterator(new int[] {1, 2, 3, 4, 5, 6, 7});
        System.out.println(evenIterator.hasNext());
        System.out.println(evenIterator.hasNext());
        System.out.println(evenIterator.hasNext());
        System.out.println(evenIterator.hasNext());
        System.out.println(evenIterator.hasNext());
        System.out.println(evenIterator.hasNext());
        System.out.println(evenIterator.hasNext());

        System.out.println(evenIterator.hasNext());
        System.out.println(evenIterator.hasNext());

//        System.out.println(evenIterator.next());
//        System.out.println(evenIterator.next());
//        System.out.println(evenIterator.next());
//        System.out.println(evenIterator.next());
//        System.out.println(evenIterator.next());
//        System.out.println(evenIterator.next());
//        System.out.println(evenIterator.next());
//        System.out.println(evenIterator.next());
//        System.out.println(evenIterator.next());
//        System.out.println(evenIterator.next());
    }
}