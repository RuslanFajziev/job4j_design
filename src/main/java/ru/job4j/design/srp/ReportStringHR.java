package ru.job4j.design.srp;

import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringWriter;

import java.util.function.Predicate;

public class ReportStringHR implements ReportString {
    private Store store;

    public ReportStringHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter, String typeExport) throws JAXBException, IOException {
        StringBuilder text = new StringBuilder();
        if (typeExport.equals("simple")) {
            text.append("Name; Salary;")
                    .append(System.lineSeparator());
            for (Employee employee : store.findBy(filter)) {
                text.append(employee.getName()).append(";")
                        .append(employee.getSalary()).append(";")
                        .append(System.lineSeparator());
            }
        } else if (typeExport.equals("html")) {
            text.append("<!DOCTYPE html>").append(System.lineSeparator())
                    .append("<html lang=\"ru\">").append(System.lineSeparator())
                    .append("<meta charset=\"UTF-8\">").append(System.lineSeparator())
                    .append("<title>Отчет о работниках отдела HR</title>").append(System.lineSeparator())
                    .append("</head>").append(System.lineSeparator())
                    .append("<body>").append(System.lineSeparator())
                    .append("<h2>Отчет о работниках отдела HR</h2>").append(System.lineSeparator());
            for (Employee employee : store.findBy(filter)) {
                text.append("<h3>Name - ").append(employee.getName()).append("</h3>").append(System.lineSeparator())
                        .append("Salary - ").append(employee.getSalary()).append(";").append(System.lineSeparator());
            }
            text.append("</body>").append(System.lineSeparator())
                    .append("</html>").append(System.lineSeparator());
        } else if (typeExport.equals("JSON")) {
            var lib = new GsonBuilder().create();
            text.append(lib.toJson(store.findBy(filter)));
        } else if (typeExport.equals("XML")) {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try (StringWriter writer = new StringWriter()) {
                for (Employee employee : store.findBy(filter)) {
                    marshaller.marshal(employee, writer);
                    String result = writer.getBuffer().toString();
                    text.append(result);
                }
            }
        }
        return text.toString();
    }
}