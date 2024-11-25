package lk.ijse;

import lk.ijse.Entity.Customer;
import lk.ijse.Entity.Order;
import lk.ijse.Entity.Payment;
import lk.ijse.Entity.Product;
import lk.ijse.config.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

       Session session =  SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();


        try {
            Customer customer1 = new Customer("Sanija", "Galle", 70000.00);

            Customer customer2 = new Customer("Maleesha", "Galle", 65000.00);

            Customer customer3 = new Customer( "Gayshan", "negambo", 60000.00 );

            session.save(customer1);
            session.save(customer2);
            session.save(customer3);



            Product product1 = new Product("Laptop", 1200.00);
            session.save(product1);

            Product product2 = new Product("MSI", 4000.00);
            session.save(product2);



            Order order1 = new Order(customer1, Arrays.asList(product1, product2), 5200.00);
            Order order2 = new Order(customer2, Arrays.asList(product2), 7000.00);

            session.save(order1);
            session.save(order2);


//        Crete payment and payment

            Payment payment1 = new Payment(order1, LocalDate.now(), 5200.00);
            session.save(payment1);


            transaction.commit();
            System.out.println("Data saved successfully");

        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();

        }

    }
}