package ru.job4j.baseemails;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

public class UserBaseEmailTest {

    @Test
    public void testAdd() {
        UserEmail<String, List> usr1 = new UserEmail("name1", List.of("ivanov@mail.ru", "petrov@ya.ru"));
        UserEmail<String, List> usr2 = new UserEmail("name2", List.of("pupkin@mail.ru", "sidorov@ya.ru"));
        UserEmail<String, List> usr3 = new UserEmail("name3", List.of("ivanov@mail.ru", "kazlov@ya.ru"));
        UserBaseEmail usrBsEm = new UserBaseEmail();
        UserBaseEmail usrBsEm2 = new UserBaseEmail();
        usrBsEm.add(usr1);
        usrBsEm.add(usr2);
        assertFalse(usrBsEm.add(usr2));
        usrBsEm.add(usr3);
        usrBsEm.add(usr3);
        usrBsEm2.add(usr1);
        usrBsEm2.add(usr2);
        usrBsEm2.add(usr3);
        assertThat(usrBsEm.getLstUser(), is(usrBsEm2.getLstUser()));
    }

    @Test
    public void testDel() {
        UserEmail<String, List> usr1 = new UserEmail("name1", List.of("ivanov@mail.ru", "petrov@ya.ru"));
        UserEmail<String, List> usr2 = new UserEmail("name2", List.of("pupkin@mail.ru", "sidorov@ya.ru"));
        UserEmail<String, List> usr3 = new UserEmail("name3", List.of("ivanov@mail.ru", "kazlov@ya.ru"));
        UserBaseEmail usrBsEm = new UserBaseEmail();
        UserBaseEmail usrBsEm2 = new UserBaseEmail();
        usrBsEm.add(usr1);
        usrBsEm.add(usr2);
        usrBsEm.add(usr3);
        assertTrue(usrBsEm.del(usr3));
        assertFalse(usrBsEm.del(usr3));
        usrBsEm2.add(usr1);
        usrBsEm2.add(usr2);
        assertThat(usrBsEm.getLstUser(), is(usrBsEm2.getLstUser()));
    }

    @Test
    public void testCheck() {
        UserEmail<String, List> usr1 = new UserEmail("name1", List.of("1@mail.ru", "2@ya.ru"));
        UserEmail<String, List> usr2 = new UserEmail("name2", List.of("2@ya.ru", "4@ya.ru"));
        UserBaseEmail usrBsEm = new UserBaseEmail();
        usrBsEm.add(usr1);
        usrBsEm.add(usr2);
        assertTrue(usrBsEm.check((List) usrBsEm.getLstUser().get(0).getEmail(), (List) usrBsEm.getLstUser().get(1).getEmail()));
    }

    @Test
    public void testUnite() {
        UserEmail<String, List> usr1 = new UserEmail("name1", List.of("1@mail.ru", "2@ya.ru"));
        UserEmail<String, List> usr2 = new UserEmail("name2", List.of("2@ya.ru", "4@ya.ru"));
        UserBaseEmail usrBsEm = new UserBaseEmail();
        usrBsEm.add(usr1);
        usrBsEm.add(usr2);
        assertThat(usrBsEm.unite((List) usrBsEm.getLstUser().get(0).getEmail(), (List) usrBsEm.getLstUser().get(1).getEmail()),
                is(List.of("1@mail.ru", "2@ya.ru", "4@ya.ru")));
    }

    @Test
    public void testCompression() {
        UserEmail<String, List> usr1 = new UserEmail("name1", List.of("ivanov@mail.ru", "petrov@ya.ru"));
        UserEmail<String, List> usr2 = new UserEmail("name2", List.of("pupkin@mail.ru", "sidorov@ya.ru"));
        UserEmail<String, List> usr3 = new UserEmail("name3", List.of("ivanov@mail.ru", "kazlov@ya.ru"));
        UserEmail<String, List> usr4 = new UserEmail("name4", List.of("chibis@mail.ru", "petrov@ya.ru"));
        UserEmail<String, List> usr5 = new UserEmail("name5", List.of("pupkin@mail.ru", "zorro@ya.ru"));
        UserEmail<String, List> usr6 = new UserEmail("name6", List.of("putin@mail.ru", "null@ya.ru"));
        UserEmail<String, List> usr7 = new UserEmail("name7", List.of("medvedev@mail.ru", "null@ya.ru"));
        UserEmail<String, List> usr8 = new UserEmail("name8", List.of("solovev@mail.ru", "medvedev@mail.ru"));
        UserBaseEmail usrBsEm = new UserBaseEmail();
        usrBsEm.add(usr1);
        usrBsEm.add(usr2);
        usrBsEm.add(usr3);
        usrBsEm.add(usr4);
        usrBsEm.add(usr5);
        usrBsEm.add(usr6);
        usrBsEm.add(usr7);
        usrBsEm.add(usr8);
        usrBsEm.compression();
        UserBaseEmail usrBsEm2 = new UserBaseEmail();
        UserEmail<String, List> usr10 = new UserEmail("name1", List.of("ivanov@mail.ru", "petrov@ya.ru", "kazlov@ya.ru", "chibis@mail.ru"));
        UserEmail<String, List> usr11 = new UserEmail("name2", List.of("pupkin@mail.ru", "sidorov@ya.ru", "zorro@ya.ru"));
        UserEmail<String, List> usr12 = new UserEmail("name6", List.of("putin@mail.ru", "null@ya.ru", "medvedev@mail.ru", "solovev@mail.ru"));
        usrBsEm2.add(usr10);
        usrBsEm2.add(usr11);
        usrBsEm2.add(usr12);
        assertThat(usrBsEm.getLstUser(), is(usrBsEm2.getLstUser()));
    }
}