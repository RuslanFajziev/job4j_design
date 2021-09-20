package ru.job4j.design.srp;

import java.util.function.Predicate;

public interface ReportString {
    String generate(Predicate<Employee> filter);
}