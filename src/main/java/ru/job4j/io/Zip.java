package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toString())))) {
            for (var source : sources) {
                zip.putNextEntry(new ZipEntry(source.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        List<Path> lst = List.of(Paths.get("d:\\2705\\LogFilter - Copy.txt"),
//                Paths.get("d:\\2705\\LogFilter.txt"));
//        new Zip().packFiles(lst, Paths.get("d:\\2705\\LogFilterALl.java.zip"));
//
//        new Zip().packSingleFile(
//                new File("d:\\2705\\LogFilter.txt"),
//                new File("d:\\2705\\LogFilter.java.zip")
//        );

        if (args.length < 3) {
            throw new IllegalArgumentException("Running Jar with only three arguments!");
        }
        /**
         * -d - directory - которую мы хотим архивировать
         * -e - exclude - исключить файлы *.xml
         * -o - output - во что мы архивируем.
         * java -jar pack.jar -d=c:\\project\\job4j\\ -e=xml -o=project.zip
         */
        ArgsName jvm = ArgsName.of(new String[]{args[0], args[1], args[2]});
        Path directory = Paths.get(jvm.get("d"));
        String exclude = jvm.get("e");
        Path output = Paths.get(jvm.get("o"));
        Predicate<Path> predicate = p -> !p.toFile().getName().endsWith(exclude);
        List<Path> input = Search.search(directory, predicate);
        Zip archiving = new Zip();
        archiving.packFiles(input, output);
    }
}