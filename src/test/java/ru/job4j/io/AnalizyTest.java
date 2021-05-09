package ru.job4j.io;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class AnalizyTest {
    @Test
    public void test() throws FileNotFoundException {
        Analizy analizy = new Analizy();
        String source = "src\\main\\resources\\source_1.csv";
        String target = "src\\main\\resources\\target_1.csv";
        analizy.unavailable(source, target);
        String[] right = "Down 10:58:01;Up 10:59:01;Down 11:01:02;Up 11:02:02".split(";");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(target));
        List<String> lst = bufferedReader.lines().filter(x -> x.length() > 0).collect(Collectors.toList());
        Iterator<String> iter = lst.listIterator();
        assertEquals(iter.next(), right[0]);
        assertEquals(iter.next(), right[1]);
        assertEquals(iter.next(), right[2]);
        assertEquals(iter.next(), right[3]);
    }

    @Test
    public void test2() throws FileNotFoundException {
        Analizy analizy = new Analizy();
        String source = "src\\main\\resources\\source_2.csv";
        String target = "src\\main\\resources\\target_2.csv";
        analizy.unavailable(source, target);
        String[] right = "Up 10:57:01;Down 10:58:01;Up 10:59:01;Down 11:01:02;Up 22:02:02".split(";");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(target));
        List<String> lst = bufferedReader.lines().filter(x -> x.length() > 0).collect(Collectors.toList());
        Iterator<String> iter = lst.listIterator();
        assertEquals(iter.next(), right[0]);
        assertEquals(iter.next(), right[1]);
        assertEquals(iter.next(), right[2]);
        assertEquals(iter.next(), right[3]);
    }

    @Test
    public void test3() throws FileNotFoundException {
        Analizy analizy = new Analizy();
        String source = "src\\main\\resources\\source_3.csv";
        String target = "src\\main\\resources\\target_3.csv";
        analizy.unavailable(source, target);
        String right = "Up 10:57:01";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(target));
        List<String> lst = bufferedReader.lines().filter(x -> x.length() > 0).collect(Collectors.toList());
        Iterator<String> iter = lst.listIterator();
        assertEquals(iter.next(), right);
    }

    @Test
    public void test4() throws FileNotFoundException {
        Analizy analizy = new Analizy();
        String source = "src\\main\\resources\\source_4.csv";
        String target = "src\\main\\resources\\target_4.csv";
        analizy.unavailable(source, target);
        String right = "Down 10:58:01";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(target));
        List<String> lst = bufferedReader.lines().filter(x -> x.length() > 0).collect(Collectors.toList());
        Iterator<String> iter = lst.listIterator();
        assertEquals(iter.next(), right);
    }
}