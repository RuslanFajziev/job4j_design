package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineForHR implements Report {

    private Store store;

    public ReportEngineForHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return null;
    }

    public String generateForHR(Predicate<Employee> filter) {
        Comparator<Employee> myComparator = (left, right) -> (int) (left.getSalary() - right.getSalary());
        List<Employee> lst = store.findBy(filter);
        lst.sort(myComparator);
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary; TypeSalary;")
                .append(System.lineSeparator());
        for (Employee employee : lst) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(employee.getTypeSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}