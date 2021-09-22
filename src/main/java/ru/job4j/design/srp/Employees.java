package ru.job4j.design.srp;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employee")
public class Employees {
    private List<Employee> employee;

    public Employees(List<Employee> employee) {
        this.employee = employee;
    }

    public Employees() {
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}