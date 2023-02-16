package com.example.demo.Demo;

import com.example.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new student object");
            Student student = new Student("Tautvydas","Navickas","manoemail@gmail.com");
            session.beginTransaction();
            System.out.println("saving student");
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            factory.close();
        }


    }
}
