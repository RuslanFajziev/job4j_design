package ru.job4j.design.isp;

public interface UserAction {
    String name();

    boolean execute(Input input, MemStore memStore);
}
