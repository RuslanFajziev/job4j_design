package ru.job4j.io.duplicates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вводи пусть, чувак:");
        String puthMy = reader.readLine();
        Files.walkFileTree(Path.of(puthMy), new DuplicatesVisitor());
    }
}