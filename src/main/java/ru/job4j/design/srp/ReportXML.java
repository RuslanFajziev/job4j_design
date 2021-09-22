package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportXML implements ReportString {
    private Store store;

    public ReportXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try (StringWriter writer = new StringWriter()) {
                    marshaller.marshal(new Employees(store.findBy(filter)), writer);
                    String result = writer.getBuffer().toString();
                    text.append(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}