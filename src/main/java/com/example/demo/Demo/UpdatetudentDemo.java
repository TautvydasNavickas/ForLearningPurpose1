package com.example.demo.Demo;

import com.example.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdatetudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;
            session.beginTransaction();
            Student student1 = session.get(Student.class, studentId);
            System.out.println("Updating student");
            student1.setFirstName("Kabisnokvassssss");
            session.getTransaction().commit();
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Updating all email");
            session.createQuery("update Student set email='lala@bmail.com'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            factory.close();
        }


    }
}
