package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        List<String> lstText = Files.readAllLines(Paths.get(botAnswers), Charset.forName("UTF-8"));
        List<String> lstLog = new ArrayList<>();
        Random random = new Random();
        System.out.println("-------------------------------------------------------");
        System.out.println("Пробуй вводить текст:");
        System.out.println("-------------------------------------------------------");
        lstLog.add("-------------------------------------------------------");
        lstLog.add("Пробуй вводить текст:");
        lstLog.add("-------------------------------------------------------");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputText = "";
        String statusRequest = "продолжить";
        while (!inputText.contains(OUT)) {
            inputText = reader.readLine();
            lstLog.add(inputText);
            if (inputText.contains(OUT)) {
                break;
            } else if (statusRequest.contains(CONTINUE) && !inputText.contains(STOP)) {
                String request = lstText.get(random.nextInt(lstText.size() - 1));
                lstLog.add(request);
                System.out.println(request);
            } else if (inputText.contains(STOP)) {
                statusRequest = STOP;
            } else if (inputText.contains(CONTINUE)) {
                statusRequest = CONTINUE;
            }
        }
        lstLog.add("-------------------------------------------------------");
        lstLog.add("Завершение сеанса чата");
        lstLog.add("-------------------------------------------------------");
        wrightLog(lstLog);
    }

    public void wrightLog(List<String> lstLog) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            for (var line : lstLog) {
                out.write(line);
                out.newLine();
            }

        } catch (Exception e) {
//            e.printStackTrace();
            LOG.error("Error opening file to write", e);
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("\\projects\\job4j_design\\src\\main\\resources\\ConsoleChat.log",
                "\\projects\\job4j_design\\src\\main\\resources\\RundomText.txt");
        cc.run();
    }
}