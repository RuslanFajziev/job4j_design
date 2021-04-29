package ru.job4j.baseemails;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapUserEmailTest {
    @Test
    public void test() {
        Map<String, Set<String>> accountRew = new HashMap<>();
        accountRew.put("name1", Set.of("ivanov@mail.ru", "petrov@ya.ru"));
        accountRew.put("name2", Set.of("pupkin@mail.ru", "sidorov@ya.ru"));
        accountRew.put("name3", Set.of("ivanov@mail.ru", "kazlov@ya.ru"));
        accountRew.put("name4", Set.of("chibis@mail.ru", "petrov@ya.ru"));
        accountRew.put("name5", Set.of("pupkin@mail.ru", "zorro@ya.ru"));
        accountRew.put("name6", Set.of("putin@mail.ru", "null@ya.ru"));
        accountRew.put("name7", Set.of("medvedev@mail.ru", "null@ya.ru"));
        accountRew.put("name8", Set.of("solovev@mail.ru", "medvedev@mail.ru"));
        Map<String, Set<String>> accountDiff = new HashMap<>();
        accountDiff.put("name1", Set.of("ivanov@mail.ru", "petrov@ya.ru", "kazlov@ya.ru", "chibis@mail.ru"));
        accountDiff.put("name2", Set.of("pupkin@mail.ru", "sidorov@ya.ru", "zorro@ya.ru"));
        accountDiff.put("name6", Set.of("putin@mail.ru", "null@ya.ru", "medvedev@mail.ru", "solovev@mail.ru"));
        assertThat(MapUserEmail.merge(accountRew), is(accountDiff));
    }
}