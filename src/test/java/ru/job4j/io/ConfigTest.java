package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void test1() {
        String path = "src\\main\\resources\\Config1.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name1"), is("Petr Arsentev"));
        assertThat(config.value("name3"), is("Medvedev Dimon"));
    }

    @Test
    public void test2() {
        String path = "src\\main\\resources\\Config1.properties";
        Config config = new Config(path);
        config.load();
        assertNull(config.value("name4"));
    }
}