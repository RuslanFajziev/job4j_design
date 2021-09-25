package ru.job4j.design.srp;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Calendar;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class ReportStringTest {

    @Test
    public void checkBuhReportString() throws JAXBException, IOException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 150, "RUB");
        Employee worker2 = new Employee("Stepan", now, now, 200, "RUB");
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
                .append(worker1.getTypeSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getHired()).append(";")
                .append(worker2.getFired()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(worker2.getTypeSalary()).append(";")
                .append(System.lineSeparator());
        Predicate<Employee> predicate = em -> em.getSalary() >= 100;
        assertEquals(engine.generate(predicate), expect.toString());
    }

    @Test
    public void checkHRReportString() throws JAXBException, IOException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", 200);
        Employee worker2 = new Employee("Stepan", 150);
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
    public void checkProgReportStringHTML() throws IOException, JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 200);
        Employee worker2 = new Employee("Stepan", now, now, 150);
        store.add(worker2);
        store.add(worker1);
        store.sortSalary();
        ReportString engine = new ReportStringHTMLProg(store);
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE html>").append(System.lineSeparator())
                .append("<html lang=\"ru\">").append(System.lineSeparator())
                .append("<meta charset=\"UTF-8\">").append(System.lineSeparator())
                .append("<title>Отчет о работниках отдела разработки</title>").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<h2>Отчет о работниках отдела разработки</h2>").append(System.lineSeparator())
                .append("<h3>Name - ").append(worker1.getName()).append("</h3>").append(System.lineSeparator())
                .append("Hired - ").append(worker1.getHired()).append(";").append(System.lineSeparator())
                .append("Fired - ").append(worker1.getFired()).append(";").append(System.lineSeparator())
                .append("Salary - ").append(worker1.getSalary()).append(";").append(System.lineSeparator())
                .append("<h3>Name - ").append(worker2.getName()).append("</h3>").append(System.lineSeparator())
                .append("Hired - ").append(worker2.getHired()).append(";").append(System.lineSeparator())
                .append("Fired - ").append(worker2.getFired()).append(";").append(System.lineSeparator())
                .append("Salary - ").append(worker2.getSalary()).append(";").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        Predicate<Employee> predicate = em -> em.getSalary() >= 100;
        assertEquals(engine.generate(predicate), text.toString());
//        ReportString engine2 = new ReportXML(store);
//        System.out.println(engine2.generate(predicate));
    }
}