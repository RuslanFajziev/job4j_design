package ru.job4j.io;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.rules.TemporaryFolder;
import org.junit.Rule;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void test() throws FileNotFoundException {
        Analizy analizy = new Analizy();
        String source = "./src/main/resources/source_1.csv";
        String target = "./src/main/resources/target_1.csv";
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
        String source = "./src/main/resources/source_2.csv";
        String target = "./src/main/resources/target_2.csv";
        analizy.unavailable(source, target);
        String[] right = "Down 10:58:01;Up 10:59:01;Down 11:01:02;Up 22:02:02".split(";");
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
        String source = "./src/main/resources/source_3.csv";
        String target = "./src/main/resources/target_3.csv";
        analizy.unavailable(source, target);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(target));
        assertEquals(bufferedReader.lines().filter(x -> x.length() > 0).count(), 0);
    }

    @Test
    public void test4() throws FileNotFoundException {
        Analizy analizy = new Analizy();
        String source = "./src/main/resources/source_4.csv";
        String target = "./src/main/resources/target_4.csv";
        analizy.unavailable(source, target);
        String right = "Down 10:58:01";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(target));
        List<String> lst = bufferedReader.lines().filter(x -> x.length() > 0).collect(Collectors.toList());
        Iterator<String> iter = lst.listIterator();
        assertEquals(iter.next(), right);
    }

    @Test
    public void test5() throws IOException {
        Analizy analizy = new Analizy();
        File source = folder.newFile("source_5.csv");
        File target = folder.newFile("target_5.csv");
        File diff = folder.newFile("diff_5.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("400 10:58:01");
            out.println("400 10:58:02");
            out.println("300 10:59:01");
            out.println("200 10:59:02");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        try (PrintWriter out = new PrintWriter(diff)) {
            out.println("Down 10:58:01");
            out.println("Up 10:59:01");
            out.println("Down 11:01:02");
            out.println("Up 11:02:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        try (BufferedReader readTarget = new BufferedReader(new FileReader(target))) {
            try (BufferedReader readDiff = new BufferedReader(new FileReader(diff))) {
                List<String> lstTarget = readTarget.lines().filter(x -> x.length() > 0).collect(Collectors.toList());
                List<String> lstDiff = readDiff.lines().filter(x -> x.length() > 0).collect(Collectors.toList());
                Iterator<String> iterTarget = lstTarget.listIterator();
                Iterator<String> iterDiff = lstDiff.listIterator();
                while (iterTarget.hasNext()) {
                    assertEquals(iterTarget.next(), iterDiff.next());
                }
            }
        }
    }
}