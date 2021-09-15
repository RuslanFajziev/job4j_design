package ru.job4j.design.srp;

import java.io.*;

public class ExportReportToHTML implements ExportReport {
    public void export(String reportString, String reportExportFormat) throws IOException {
        try (FileWriter fw = new FileWriter(reportExportFormat);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(reportString);
        }
    }
}