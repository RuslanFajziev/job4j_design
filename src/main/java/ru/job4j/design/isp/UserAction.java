package ru.job4j.design.isp;

public interface UserAction {
    String name();

    boolean execute(Input input, MemStore rootStore, MemStore currentStore);
}
