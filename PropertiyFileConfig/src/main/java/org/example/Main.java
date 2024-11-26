package org.example;

import org.example.config.SessionFactoryConfig;
import org.example.entity.Department;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        Session session = SessionFactoryConfig.getInstance().getSession();
//       Transaction transaction =  session.beginTransaction();

       Session session = SessionFactoryConfig.getInstance().getSession();
       Transaction transaction = session.beginTransaction();

        Department department = new Department("IT department");

        Employee employee1 = new Employee(1, "Maleesha", "Galle", 50000.00, department);
        Employee employee2 = new Employee(2, "Dileesha", "Pandura", 5000.00, department);

        department.setEmployees(Arrays.asList(employee1, employee2));
        session.save(department);
        transaction.commit();
        System.out.println("Data Saved!!");
        session.close();

    }
}