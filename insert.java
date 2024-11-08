package com.hib.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.qn.Entity.student;
import com.qn.Entity.address;

public class insert {
    public static void main(String[] args) {
       SessionFactory factory=new Configuration().configure().
    		   addAnnotatedClass(student.class).
    		   addAnnotatedClass(address.class).
    		   buildSessionFactory();
       Session session=factory.getCurrentSession();
       address address = new address("123 Main St", "New York", "10001");

       // Create a new Student and associate the Address
       student student = new student("John", "Doe", "john.doe@example.com", address);

       // Begin transaction
       session.beginTransaction();

       // Save the student (This will also save the address due to CascadeType.ALL)
       session.save(student);

       // Commit the transaction
       session.getTransaction().commit();

       System.out.println("Student and Address saved successfully!");
    }
}
