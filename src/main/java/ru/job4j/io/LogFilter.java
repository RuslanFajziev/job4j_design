package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            return (List<String>) in.lines().filter(x -> x.contains("404"))
                    .map(y -> y + System.lineSeparator()).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of("ПУСТО");
    }

    public static void save(List<String> list, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (var str : list) {
                out.write(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}