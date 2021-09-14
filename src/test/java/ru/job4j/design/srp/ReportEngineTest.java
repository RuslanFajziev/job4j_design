package ru.job4j.design.srp;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.apache.commons.io.FileUtils;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100, "RUB");
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary; TypeSalary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(worker.getTypeSalary()).append(";")
                .append(System.lineSeparator());
        Predicate<Employee> predicate = em -> em.getSalary() >= 100;
        assertThat(engine.generate(predicate), is(expect.toString()));
    }


    @Test
    public void whenGeneratedForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100, "RUB");
        Employee worker2 = new Employee("Stepan", now, now, 98, "RUB");
        Employee worker3 = new Employee("Nurlan", now, now, 150, "RUB");
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        ReportEngineForHR engine = new ReportEngineForHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary; TypeSalary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(worker2.getTypeSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(worker1.getTypeSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(worker3.getTypeSalary()).append(";")
                .append(System.lineSeparator());
        Predicate<Employee> predicate = em -> em.getSalary() >= 98;
        assertThat(engine.generateForHR(predicate), is(expect.toString()));
    }

    @Test
    public void checkExportHTML() throws IOException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100, "RUB");
        Employee worker2 = new Employee("Stepan", now, now, 98, "RUB");
        Employee worker3 = new Employee("Nurlan", now, now, 150, "RUB");
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        ReportEngineForHR engine = new ReportEngineForHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary; TypeSalary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(worker2.getTypeSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(worker1.getTypeSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(worker3.getTypeSalary()).append(";")
                .append(System.lineSeparator());
        Predicate<Employee> predicate = em -> em.getSalary() >= 98;
        String left = "d:\\test\\left.html";
        String right = "d:\\test\\right.html";
        ExportReportToHTML.exportToHTML(engine.generateForHR(predicate), left);
        ExportReportToHTML.exportToHTML(expect.toString(), right);
        assertEquals(FileUtils.readLines(new File(left)), FileUtils.readLines(new File(right)));
    }
}