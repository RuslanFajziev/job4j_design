package ru.job4j.findfiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class FindFiles {

    /**
     * -d - директория, в которой начинать поиск
     * -n - имя файла, маска
     * -t - тип поиска: mask искать по маске, name по полному совпадение имени, regex по регулярному выражению
     * -o - результат записать в файл
     *
     * java -jar target/findfiles.jar -d=d:\share_vm\check\ -n=xml -t=mask -o=d:\my.log
     */

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Empty parameter list!");
        } else if (args.length < 4) {
            throw new IllegalArgumentException("Parameters must be 4");
        }
        ArgmBase argmBase = ArgmBase.of(new String[]{args[0], args[1], args[2], args[3]});
        String searchType = argmBase.getValue("t");
        String nameOrMask = argmBase.getValue("n");
        Predicate<Path> predicate = getSearchCondition(nameOrMask, searchType);
        Path start = Paths.get(argmBase.getValue("d"));
        List<Path> lstPath = Search.search(start, predicate);
        String outFile = argmBase.getValue("o");
        writeLog(outFile, lstPath);
    }

    public static Predicate<Path> getSearchCondition(String nameOrMask, String searchType) {
        if (searchType.equals("mask")) {
            return p -> p.toFile().getName().contains(nameOrMask);
        } else if (searchType.equals("name")) {
            return p -> p.toFile().getName().endsWith(nameOrMask);
        } else {
            throw new IllegalArgumentException("Parameter type error, mask or name only");
        }
    }

    public static void writeLog(String outFile, List<Path> lstPath) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(outFile, Charset.forName("WINDOWS-1251"), false))) {
            for (var line : lstPath) {
                out.write(String.valueOf(line));
                out.newLine();
            }
        }
    }
}
