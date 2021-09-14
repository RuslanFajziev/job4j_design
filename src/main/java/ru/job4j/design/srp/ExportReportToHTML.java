package ru.job4j.design.srp;

import java.io.*;

public class ExportReportToHTML {
    public static void exportToHTML(String reportString, String reportHtml) throws IOException {
        try (FileWriter fw = new FileWriter(reportHtml);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            out.println(reportString);
        }
    }
}