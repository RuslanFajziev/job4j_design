package ru.job4j.postgre.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class ConnectionJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Settings settings = new Settings();
        try (FileInputStream io = new FileInputStream("./src/main/resources/app.properties")) {
            settings.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Class.forName("org.postgresql.Driver");
//        String url = "jdbc:postgresql://localhost:5432/helpdesk";
//        String login = "postgres";
//        String password = "password";
        String url = settings.getValue("url");
        String login = settings.getValue("login");
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.printf("%s %n%s%s%n%s%s %n", "Введите пароль для подключения", "url:", url, "login:", login);
        String password = input.nextLine();
        System.out.println("--------------------------------");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDatabaseProductName());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getDriverVersion());
        }
        System.out.println("--------------------------------");
    }
}

class Settings {
    private final Properties properties = new Properties();

    public void load(InputStream io) {
        try {
            this.properties.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return this.properties.getProperty(key);
    }
}