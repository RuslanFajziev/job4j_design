package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.io.File;

public class ConfigTest {

    @Test
    public void test1() {
        String path = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Config1.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name1"), is("Petr Arsentev"));
        assertThat(config.value("name3"), is("Medvedev Dimon"));
    }

    @Test
    public void test2() {
        String path = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Config1.properties";
        Config config = new Config(path);
        config.load();
        assertNull(config.value("name4"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        String path = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Config3.properties";
        Config config = new Config(path);
        config.load();
    }

}