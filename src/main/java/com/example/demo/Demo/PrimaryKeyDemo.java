package com.example.demo.Demo;

import com.example.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating 3 student objects");
            Student student = new Student("Mobis","Nobis","lobis@gmail.com");
            Student student1 = new Student("Simona","Grybauskaite","simonosemail@gmail.com");
            Student student2 = new Student("Kobis","Ministras","koldunas@gmail.com");
            session.beginTransaction();
            System.out.println("saving student");
            session.save(student);
            session.save(student1);
            session.save(student2);
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            factory.close();
        }


    }
}
