package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;
    private int rowOut = 0;
    private int columnOut = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    public boolean checkArray(int rowT, int columnT) {
        boolean rsl = false;
        for (int rowArray = rowT; rowArray < data.length; rowArray++) {
            int sizeRowArr = data[rowArray].length;
            if (sizeRowArr > 0) {
                rsl = true;
                rowOut = rowArray;
                columnOut = columnT;
                if (sizeRowArr > 1) {
                    column = columnT + 1;
                } else if (sizeRowArr == 1) {
                    row = rowArray + 1;
                }
                break;
            }
        }
        return rsl;
    }

    @Override
    public boolean hasNext() {
        return checkArray(row, column);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[rowOut][columnOut];
    }
}