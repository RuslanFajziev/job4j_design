package ru.job4j.design.srp;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.function.Predicate;

import static org.junit.Assert.*;
import org.apache.commons.io.FileUtils;

public class ReportStringBuhTest {

    @Test
    public void checkBuhReportString() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 150);
        Employee worker2 = new Employee("Stepan", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        ReportString engine = new ReportStringBuh(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary; TypeSalary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getHired()).append(";")
                .append(worker1.getFired()).append(";")
                .append(worker1.getSalary()).append(";")
                .append("RUB;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getHired()).append(";")
                .append(worker2.getFired()).append(";")
                .append(worker2.getSalary()).append(";")
                .append("RUB;")
                .append(System.lineSeparator());
        Predicate<Employee> predicate = em -> em.getSalary() >= 100;
        assertEquals(engine.generate(predicate), expect.toString());
    }

    @Test
    public void checkHRReportString() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 200);
        Employee worker2 = new Employee("Stepan", now, now, 150);
        store.add(worker2);
        store.add(worker1);
        store.sortSalary();
        ReportString engine = new ReportStringHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator());
        Predicate<Employee> predicate = em -> em.getSalary() >= 100;
        assertEquals(engine.generate(predicate), expect.toString());
    }

    @Test
    public void checkProgReportStringHTML() throws IOException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Employee worker1 = new Employee("Ivan", date, date, 200);
        Employee worker2 = new Employee("Stepan", date, date, 150);
        store.add(worker1);
        store.add(worker2);
        ReportStringHTMLProg engine = new ReportStringHTMLProg(store);
        Predicate<Employee> predicate = em -> em.getSalary() >= 100;
        engine.exportToHTML(predicate);
        assertEquals(FileUtils.readLines(new File("src/main/resources/ReportStringHR.html")), FileUtils.readLines(new File("src/main/resources/ReportStringHR.html")));
    }
}