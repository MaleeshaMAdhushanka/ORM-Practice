package lk.ijse.config;

import lk.ijse.Entity.Customer;
import lk.ijse.Entity.Order;
import lk.ijse.Entity.Payment;
import lk.ijse.Entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {



    private static SessionFactoryConfig factoryConfig;

    private SessionFactoryConfig() {}

    public static SessionFactoryConfig getInstance(){
      return   (factoryConfig == null) ?
                factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

public Session getSession(){


    //    Create a Service registry Creation

    StandardServiceRegistry  serviceRegistry = new StandardServiceRegistryBuilder()

//            Confugures (reads) hibernate.cfg.xml.file;
//            from its path it is src root no need to mention path,
//            but if it is present inside a package; need to mention the path

            .configure()
            .build();



    //    Create metaData and build it

    Metadata metadata = new MetadataSources(serviceRegistry)
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(Order.class)
            .addAnnotatedClass(Payment.class)
            .addAnnotatedClass(Product.class)
            .getMetadataBuilder().build();


    //    Create Session Factory

    SessionFactory sessionFactory = metadata.buildSessionFactory();

    //    Create and Open Session
//    Opened session creates and returns
//    So we should be responsible to close  the session;
    //After session 's work done
    return sessionFactory.openSession();


 }

}
