package com.example.demo.Demo;

import com.example.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new student object");
            Student student = new Student("Scobby","Lobby","puff@gmail.com");
            session.beginTransaction();
            System.out.println("saving student");
            System.out.println(student);
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Saved student. Generated id: " + student.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student student1 = session.get(Student.class, student.getId());
            System.out.println("Get complete: " + student1);
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            factory.close();
        }


    }
}
