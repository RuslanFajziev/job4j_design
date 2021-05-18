package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        List<String> lstText = Files.readAllLines(Paths.get(botAnswers), Charset.forName("UTF-8"));
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            Random random = new Random();
            System.out.println("-------------------------------------------------------");
            System.out.println("Пробуй вводить текст:");
            System.out.println("-------------------------------------------------------");
            out.write("-------------------------------------------------------" + System.lineSeparator());
            out.write("Пробуй вводить текст:" + System.lineSeparator());
            out.write("-------------------------------------------------------" + System.lineSeparator());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputText = "";
            String statusRequest = "продолжить";
            while (!inputText.contains(OUT)) {
                inputText = reader.readLine();
                out.write(inputText + System.lineSeparator());
                if (inputText.contains(OUT)) {
                    break;
                } else if (statusRequest.contains(CONTINUE) && !inputText.contains(STOP)) {
                    String request = lstText.get(random.nextInt(lstText.size() - 1));
                    out.write(request + "(ОТВЕТ)" + System.lineSeparator());
                    System.out.println(request);
                } else if (inputText.contains(STOP)) {
                    statusRequest = STOP;
                } else if (inputText.contains(CONTINUE)) {
                    statusRequest = CONTINUE;
                }
            }
            out.write("-------------------------------------------------------" + System.lineSeparator());
            out.write("Завершение сеанса чата" + System.lineSeparator());
            out.write("-------------------------------------------------------" + System.lineSeparator());
        } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("c:\\projects\\job4j_design\\src\\main\\resources\\ConsoleChat.log", "c:\\projects\\job4j_design\\src\\main\\resources\\RundomText.txt");
        cc.run();
    }
}