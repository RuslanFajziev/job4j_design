package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
                String serverStatus = "not_defined";
                while (in.ready()) {
                    String lineStatus = in.readLine();
                    if ((serverStatus == "not_defined" || serverStatus.equals("Up")) && (lineStatus.contains("400") || lineStatus.contains("500"))) {
                        out.println("Down " + lineStatus.substring(4));
                        serverStatus = "Down";
                    } else if ((serverStatus == "not_defined" || serverStatus.equals("Down")) && (lineStatus.contains("200"))) {
                        out.println("Up " + lineStatus.substring(4));
                        serverStatus = "Up";
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("src\\main\\resources\\source_0.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}