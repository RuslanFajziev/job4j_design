package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] data;
    private int row = 0;

    public EvenIterator(int[] data) {
        this.data = data;
    }

    public boolean evenNumber(int number) {
        return number % 2 == 0;
    }

    @Override
    public boolean hasNext() {
        int lnData = data.length;
        while (row < lnData && !evenNumber(data[row])) {
            row++;
        }
        return row < lnData;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row++];
    }

    public static void main(String[] args) {
        EvenIterator it = new EvenIterator(new int[]{1, 2, 3, 4, 5, 6, 7});
        it.forEachRemaining(System.out::println);

    }
}