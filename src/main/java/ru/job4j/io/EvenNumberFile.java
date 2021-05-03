package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        StringBuffer txt = new StringBuffer();
        try (FileInputStream in = new FileInputStream("even.txt")) {
            int read;
            while ((read = in.read()) != -1) {
                txt.append((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] lines = txt.toString().split(System.lineSeparator());
        System.out.println("-------------------");
        for (var ln : lines) {
            Integer number = Integer.valueOf(ln);
            if (number % 2 == 0) {
                System.out.println(ln + " - четное число");
            } else {
                System.out.println(ln + " - НЕЧЕТНОЕ число");
            }
            System.out.println("-------------------");
        }

    }
}
