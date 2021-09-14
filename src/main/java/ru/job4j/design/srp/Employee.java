package ru.job4j.design.srp;

import java.util.Calendar;

public class Employee extends EmployeeBase{
    private String typeSalary;

    public Employee(String name, Calendar hired, Calendar fired, int salary, String typeSalary) {
        super(name, hired, fired, salary);
        setTypeSalary(typeSalary);
    }

    public String getTypeSalary() {
        return typeSalary;
    }

    public void setTypeSalary(String typeSalary) {
        this.typeSalary = typeSalary;
    }
}