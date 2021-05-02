package ru.job4j.difflist;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

public class AnalizeTest {
    Analize.User usr1 = new Analize.User(1, "один");
    Analize.User usr2 = new Analize.User(2, "два");
    Analize.User usr3 = new Analize.User(3, "три");
    Analize.User usr4 = new Analize.User(4, "четыре");
    Analize.User usr5 = new Analize.User(5, "пять");
    Analize.User usr6 = new Analize.User(6, "шесть");

    @Test
    public void test() {
        Analize analize = new Analize();
        var info = analize.diff(List.of(usr1, usr2, usr3), List.of(usr1, usr2));
        Analize analize2 = new Analize();
        analize2.info.setDeleted(1);
        assertThat(info, is(analize2.info));
    }

    @Test
    public void test2() {
        Analize analize = new Analize();
        var info = analize.diff(List.of(usr1, usr2), List.of(usr1, usr2, usr3));
        Analize analize2 = new Analize();
        analize2.info.setAdded(1);
        assertThat(info, is(analize2.info));
    }

    @Test
    public void test3() {
        Analize analize = new Analize();
        var info = analize.diff(List.of(usr1, usr2, usr3), List.of(usr4, usr5, usr6));
        Analize analize2 = new Analize();
        analize2.info.setDeleted(3);
        analize2.info.setAdded(3);
        assertThat(info, is(analize2.info));
    }

    @Test
    public void test4() {
        Analize analize = new Analize();
        var info = analize.diff(List.of(usr1, usr2, usr3), List.of(usr4, usr2, usr6));
        Analize analize2 = new Analize();
        analize2.info.setDeleted(2);
        analize2.info.setAdded(2);
        assertThat(info, is(analize2.info));
    }

    @Test
    public void test5() {
        Analize analize = new Analize();
        var info = analize.diff(List.of(usr1, usr2, usr3), List.of(usr1, usr2, usr6));
        Analize analize2 = new Analize();
        analize2.info.setDeleted(1);
        analize2.info.setAdded(1);
        assertThat(info, is(analize2.info));
    }

    @Test
    public void test6() {
        Analize analize = new Analize();
        var info = analize.diff(List.of(usr1, usr2, usr3), List.of(usr4, usr5));
        Analize analize2 = new Analize();
        analize2.info.setDeleted(3);
        analize2.info.setAdded(2);
        assertThat(info, is(analize2.info));
    }

    @Test
    public void test7() {
        Analize analize = new Analize();
        var info = analize.diff(List.of(usr1, usr2), List.of(usr4, usr5, usr6));
        Analize analize2 = new Analize();
        analize2.info.setDeleted(2);
        analize2.info.setAdded(3);
        assertThat(info, is(analize2.info));
    }

    @Test
    public void test8() {
        Analize.User usr1Changed = new Analize.User(1, "почти один");
        Analize analize = new Analize();
        var info = analize.diff(List.of(usr1, usr2), List.of(usr1Changed, usr2));
        Analize analize2 = new Analize();
        analize2.info.setChanged(1);
        assertThat(info, is(analize2.info));
    }

    @Test
    public void test9() {
        Analize.User usr2Changed = new Analize.User(2, "почти два");
        Analize analize = new Analize();
        var info = analize.diff(List.of(usr1, usr2, usr3), List.of(usr4, usr2Changed, usr6));
        Analize analize2 = new Analize();
        analize2.info.setDeleted(2);
        analize2.info.setAdded(2);
        analize2.info.setChanged(1);
        assertThat(info, is(analize2.info));
    }
}