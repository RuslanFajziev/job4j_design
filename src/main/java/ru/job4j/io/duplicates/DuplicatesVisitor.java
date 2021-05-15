package ru.job4j.io.duplicates;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    List<FileProperty> lstFileProp = new ArrayList<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        String tmpName = file.toFile().getName();
        long tmpSize = file.toFile().length();
        FileProperty fileProperty = new FileProperty(tmpSize, tmpName);
        if (lstFileProp.contains(fileProperty)) {
            System.out.println("Обнаружен дуюлирующися файл: " + file.toAbsolutePath());
        } else if (!lstFileProp.contains(fileProperty)) {
            lstFileProp.add(fileProperty);
        }
        return FileVisitResult.CONTINUE;
    }
}