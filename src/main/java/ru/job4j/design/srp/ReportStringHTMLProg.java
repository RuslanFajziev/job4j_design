package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportStringHTMLProg implements ReportString {
    private Store store;

    public ReportStringHTMLProg(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
            text.append("<!DOCTYPE html>").append(System.lineSeparator())
                    .append("<html lang=\"ru\">").append(System.lineSeparator())
                    .append("<meta charset=\"UTF-8\">").append(System.lineSeparator())
                    .append("<title>Отчет о работниках отдела разработки</title>").append(System.lineSeparator())
                    .append("</head>").append(System.lineSeparator())
                    .append("<body>").append(System.lineSeparator())
                    .append("<h2>Отчет о работниках отдела разработки</h2>").append(System.lineSeparator());
            for (Employee employee : store.findBy(filter)) {
                text.append("<h3>Name - ").append(employee.getName()).append("</h3>").append(System.lineSeparator())
                        .append("Hired - ").append(employee.getHired()).append(";").append(System.lineSeparator())
                        .append("Fired - ").append(employee.getFired()).append(";").append(System.lineSeparator())
                        .append("Salary - ").append(employee.getSalary()).append(";").append(System.lineSeparator());
            }
            text.append("</body>").append(System.lineSeparator())
                    .append("</html>").append(System.lineSeparator());
        return text.toString();
    }
}