package ru.job4j.postgre.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    final private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void statementExecute(String codeExecute) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(codeExecute);
        }
    }

    public void createTable(String tableName) throws Exception {
        String codeExecute = String.format(
                "create table if not exists %s(%s, %s);",
                tableName,
                "id serial primary key",
                "name character(255)"
        );
        statementExecute(codeExecute);
    }

    public void dropTable(String tableName) throws Exception {
        String codeExecute = String.format("drop table if exists %s;", tableName);
        statementExecute(codeExecute);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        String codeExecute = String.format("ALTER TABLE %s ADD COLUMN %s %s;", tableName, columnName, type);
        statementExecute(codeExecute);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        String codeExecute = String.format("ALTER TABLE %s DROP %s;", tableName, columnName);
        statementExecute(codeExecute);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        String codeExecute = String.format("ALTER TABLE %s RENAME COLUMN %s TO %s;", tableName, columnName, newColumnName);
        statementExecute(codeExecute);
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        scheme.append(String.format("---------------------------------------------%n"));
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        scheme.append("---------------------------------------------");
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (FileInputStream io = new FileInputStream("./src/main/resources/TableEditor.properties")) {
            properties.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.dropTable("car");
        tableEditor.createTable("car");
        System.out.println(tableEditor.getScheme("car"));
        tableEditor.renameColumn("car", "name", "modelCar");
        System.out.println(tableEditor.getScheme("car"));
        tableEditor.addColumn("car", "bodyCar", "character(255)");
        System.out.println(tableEditor.getScheme("car"));
        tableEditor.dropColumn("car", "bodyCar");
        System.out.println(tableEditor.getScheme("car"));
        tableEditor.close();
    }
}