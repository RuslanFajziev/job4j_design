package ru.job4j.io.shell;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ShellTest {
    Shell shell = new Shell();

    @Test
    public void whenCdBack() {
        shell.cd("/user");
        shell.cd("../root");
        assertThat(
                shell.path(), is("/root")
        );
    }

    @Test
    public void whenAbsolutePath() {
        shell.cd("/path/to/file");
        shell.cd("/new/path/to/my/file");
        assertThat(shell.path(), is("/new/path/to/my/file"));
    }

    @Test
    public void whenCdRoot() {
        shell.cd("/");
        assertThat(
                shell.path(), is("/")
        );
    }

    @Test
    public void whenCdUserLocal() {
        shell.cd("user");
        shell.cd("local");
        assertThat(
                shell.path(), is("/user/local")
        );
    }

    @Test
    public void whenCdUserBack() {
        shell.cd("user");
        shell.cd("..");
        assertThat(
                shell.path(), is("/")
        );
    }

    @Test
    public void whenCdUserThreeBack() {
        shell.cd("user");
        shell.cd("../../../local");
        assertThat(
                shell.path(), is("/local")
        );
    }
}