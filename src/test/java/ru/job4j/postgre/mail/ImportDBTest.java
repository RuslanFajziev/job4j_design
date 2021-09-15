//package ru.job4j.postgre.mail;
//
//import static org.junit.Assert.assertThat;
//import static org.hamcrest.Matchers.is;
//import org.junit.Test;
//
//import java.io.FileInputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//
//public class ImportDBTest {
//    @Test
//    public void test() throws Exception {
//        List<String> left = List.of("Petr Arsentev", "Ivan Ivanov");
//        List<String> right = new ArrayList<>();
//        Properties cfg = new Properties();
//        try (FileInputStream in = new FileInputStream("./src/main/resources/ImportDB.properties")) {
//            cfg.load(in);
//        }
//        ImportDB db = new ImportDB(cfg, "./src/main/resources/dumpSpammers.txt");
//        db.save(db.load());
//        Class.forName(cfg.getProperty("jdbc.driver"));
//        try (Connection cnt = DriverManager.getConnection(
//                cfg.getProperty("jdbc.url"),
//                cfg.getProperty("jdbc.username"),
//                cfg.getProperty("jdbc.password")
//        )) {
//            try (PreparedStatement ps = cnt.prepareStatement("select name from users")) {
//                try (ResultSet resultSet = ps.executeQuery()) {
//                    while (resultSet.next()) {
//                        right.add(resultSet.getString(1));
//                    }
//                }
//            }
//        }
//        assertThat(left.get(0), is(right.get(0)));
//        assertThat(left.get(1), is(right.get(1)));
//    }
//}