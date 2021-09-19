package ru.job4j.design.srp;

import javax.xml.bind.JAXBException;
import java.util.function.Predicate;

public interface ReportString {
    String generate(Predicate<Employee> filter) throws JAXBException;
}