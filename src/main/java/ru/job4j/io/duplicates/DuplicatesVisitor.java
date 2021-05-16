package ru.job4j.io.duplicates;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    HashSet<FileProperty> setFileProp = new HashSet<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        String tmpName = file.toFile().getName();
        long tmpSize = file.toFile().length();
        FileProperty fileProperty = new FileProperty(tmpSize, tmpName);
        if (!setFileProp.add(fileProperty)) {
            System.out.println("Обнаружен дуюлирующися файл: " + file.toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }
}