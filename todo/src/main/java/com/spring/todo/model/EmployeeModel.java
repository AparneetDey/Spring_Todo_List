package com.spring.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class EmployeeModel {
    private int id;
    private String name;
    private String department;
    private float salary;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDepaString() {
        return this.department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public float getSalary() {
        return salary;
    }
}
