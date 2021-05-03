package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int index = 1; index <= 9; index++) {
                String txt = Integer.toString(1 * index);
                out.write(("1 x " + txt + " = " + txt + System.lineSeparator()).getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}