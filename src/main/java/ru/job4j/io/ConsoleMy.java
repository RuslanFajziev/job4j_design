package ru.job4j.io;

import java.io.Console;

public class ConsoleMy {
    public static void main(String[] args) {
        // получаем консоль
        Console console = System.console();
        if (console != null) {
            // считываем данные с консоли
            String login = console.readLine("Enter the login:");
            char[] password = console.readPassword("Enter the password:");

            console.printf("Enter the login: %s \n", login);
            console.printf("Enter the password: %s \n", new String(password));
        }
    }
}
