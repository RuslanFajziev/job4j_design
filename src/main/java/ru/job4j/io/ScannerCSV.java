package ru.job4j.io;

import java.io.*;
import java.util.*;

public class ScannerCSV {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        /* TODO parse args to values. */
        for (var elmArgs : args) {
            String[] arrString = elmArgs.split("=");
            if (arrString.length == 1) {
                throw new IllegalArgumentException("(Stage_2) One of the parameters is empty!");
            }
            values.put(arrString[0].substring(1), arrString[1]);
        }
        if (!(values.containsKey("path") && values.containsKey("delimiter") && values.containsKey("out") && values.containsKey("filter"))) {
            throw new IllegalArgumentException("(Stage_2) Incorrect program startup key set!");
        }
    }

    public static ScannerCSV of(String[] args) {
        /* TODO parse args to values. */
        if (args.length == 0) {
            throw new IllegalArgumentException("(Stage_1) Empty parameter list!");
        } else if (args.length != 4) {
            throw new IllegalArgumentException("(Stage_1) Starting is possible with four parameters!");
        }
        ScannerCSV scannerCsv = new ScannerCSV();
        scannerCsv.parse(args);
        return scannerCsv;
    }

    public void outFilterCSV(List<Integer> listIndexWord, String out, String delimiter, int lensHeadings, String filePath) throws IOException {
        int counter = 1;
        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            String txt;
            while ((txt = in.readLine()) != null) {
                var scannerNew = new Scanner(txt).useDelimiter(delimiter);
                if (out.equals("stdout")) {
                    while (scannerNew.hasNext()) {
                        String txtOut = scannerNew.next();
                        if (listIndexWord.contains(counter)) {
                            listIndexWord.add(counter + lensHeadings);
                            System.out.println(txtOut);
                        }
                        counter++;
                    }
                } else {
                    try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(out, true)))) {
                        while (scannerNew.hasNext()) {
                            String txtOut = scannerNew.next();
                            if (listIndexWord.contains(counter)) {
                                listIndexWord.add(counter + lensHeadings);
                                pw.println(txtOut);
                            }
                            counter++;
                        }
                    }
                }
            }
        }
    }

    public void readerCSV() throws Exception {
        var filePath = values.get("path");
        var delimiter = values.get("delimiter");
        var out = values.get("out");
        var filter = values.get("filter");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            Optional<String> rsl = bufferedReader.lines().findFirst();
            if (rsl.isPresent()) {
                String headingsAllLine = rsl.get();  // Строка названия столбцов
                String[] headings = headingsAllLine.split(delimiter); // Массив названий столбцов
                int lensHeadings = headings.length; // Длинна массива названий столбцов
                Set<String> filterHeadings = new HashSet<>();
                String[] filterArr = filter.split(",");
                for (var elmArr : filterArr) {
                    filterHeadings.add(elmArr);
                }
                int counter = 1;
                List<Integer> listIndexWord = new ArrayList<>(); // Массив индексов, по каторым будем будем понимать что слово необходимо вывести в файл/консоль
                for (var elm : headings) {
                    if (filterHeadings.contains(elm)) {
                        listIndexWord.add(counter);
                    }
                    counter++;
                }
                outFilterCSV(listIndexWord, out, delimiter, lensHeadings, filePath);
            } else {
                System.out.println("Empty Header List");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ScannerCSV scannerCsv = ScannerCSV.of(new String[]{"-path=src\\main\\resources\\7.csv", "-delimiter=;", "-out=src\\main\\resources\\7_out.txt", "-filter=name,education"});
//        ScannerCSV scannerCsv = ScannerCSV.of(new String[]{"-path=src\\main\\resources\\7.csv", "-delimiter=;", "-out=stdout", "-filter=name,education"});
        scannerCsv.readerCSV();
    }
}
