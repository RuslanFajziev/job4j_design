package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            return  (List<String>) in.lines().filter(x -> x.contains("404"))
                    .map(y -> y + System.lineSeparator()).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of("ПУСТО");
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}