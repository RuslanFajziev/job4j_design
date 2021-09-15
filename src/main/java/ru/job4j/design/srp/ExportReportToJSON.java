package ru.job4j.design.srp;

import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExportReportToJSON implements ExportReport {
    public void export(String reportString, String reportExportFormat) throws IOException {
        try (FileWriter fw = new FileWriter(reportExportFormat);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            var lib = new GsonBuilder().create();
            out.println(lib.toJson(reportString));
        }
    }

    public static void main(String[] args) throws IOException {
        ExportReportToJSON exp = new ExportReportToJSON();
        exp.export("Test json", "d:\\test\\test.json");
    }
}