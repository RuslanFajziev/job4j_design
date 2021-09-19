package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportStringHR implements ReportString {
    private Store store;

    public ReportStringHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        Comparator<Employee> myComparator = (left, right) -> (int) (right.getSalary() - left.getSalary());
        List<Employee> lstSorted = store.findBy(filter);
        lstSorted.sort(myComparator);
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : lstSorted) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}