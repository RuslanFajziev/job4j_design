package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int lnData = data.length;
        while (row < lnData && data[row].length == 0) {
            if (row + 1 < lnData) {
                row++;
                continue;
            }
            break;
        }
        return data[row].length > 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int rsl = data[row][column++];
        while (row < data.length && data[row].length == 1) {
            row++;
            column = 0;
        }
        return rsl;
    }
}