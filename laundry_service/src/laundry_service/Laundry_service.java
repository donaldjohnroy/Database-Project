package laundry_service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DJ
 */

import javax.persistence.*;
import java.util.*;

public class Laundry_service {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("laundry_servicePU");
        EntityManager em = emf.createEntityManager();

        // Store 1000 Point objects in the database:
        //INSERT
        em.getTransaction().begin();
        Customer c = new Customer();
        c.setCustomerId(10);
        c.setName("donald");
        c.setContactNumber(124);
        c.setAddress("dasdgashg");
        em.persist(c);            
        
        em.getTransaction().commit();
        
        
        

       
        
        

//        // Find the number of Point objects in the database:
//        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
//        System.out.println("Total Points: " + q1.getSingleResult());
//
//        // Find the average X value:
//        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
//        System.out.println("Average X: " + q2.getSingleResult());
//
//        // Retrieve all the Point objects from the database:
//        TypedQuery<Point> query =
//            em.createQuery("SELECT p FROM Point p", Point.class);
//        List<Point> results = query.getResultList();
//        for (Point p : results) {
//            System.out.println(p);
//        }

        // Close the database connection:
        //em.close();
        //DELETE
        Customer c2 = em.find(Customer.class, 40);
        em.getTransaction().begin();
        em.remove(c2);
        em.getTransaction().commit();
        
        //UPDATE
        Customer c3 = em.find(Customer.class, 20);
        
        em.getTransaction().begin();
        c3.setAddress("anahaw");
        em.merge(c3);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
