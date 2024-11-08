package com.hib.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.qn.Entity.address;
import com.qn.Entity.student;

public class reterive {
    public static void main(String[] args) {
        // Set up Hibernate session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(student.class)
                .addAnnotatedClass(address.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        
        session.beginTransaction();
student s=(student)session.get(student.class,1);
System.out.println(s);
address ad=s.getAddress();
System.out.println(ad);

        
        session.getTransaction().commit();
        
    }
}
