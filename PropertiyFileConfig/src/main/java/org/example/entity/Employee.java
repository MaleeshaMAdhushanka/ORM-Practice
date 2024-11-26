package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private int id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_address")
    private String address;

    @Column(name = "employee_salary")
    private double salary;

   @ManyToOne
   @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public Employee(){}

    public Employee(int id, String name, String address, double salary, Department department) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
