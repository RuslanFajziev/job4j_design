package ru.job4j.design.srp;

import java.io.IOException;

public interface ExportReport {
    void export(String reportString, String reportExportFormat) throws IOException;
}