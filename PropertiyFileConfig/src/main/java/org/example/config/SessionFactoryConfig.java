package org.example.config;

import org.example.entity.Department;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {

    private static SessionFactoryConfig  factoryConfig;

    private SessionFactoryConfig() {}

    public static SessionFactoryConfig getInstance(){
        return (factoryConfig == null) ?
                factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }


    public Session getSession(){

        //Create a service registry Cretion

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .loadProperties("hibernate.properties")
                .build();


        //create metaData and build it

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .getMetadataBuilder().build();


//        Crate a Session Factory
        SessionFactory sessionFactory = metadata.buildSessionFactory();

        return sessionFactory.openSession();


    }
}
