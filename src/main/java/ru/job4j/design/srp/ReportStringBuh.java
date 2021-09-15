package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportStringBuh implements ReportString {
    private Store store;

    public ReportStringBuh(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary; TypeSalary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("RUB;")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}