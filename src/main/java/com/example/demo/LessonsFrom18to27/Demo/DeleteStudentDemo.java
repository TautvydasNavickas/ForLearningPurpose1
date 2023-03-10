package com.example.demo.LessonsFrom18to27.Demo;

import com.example.demo.LessonsFrom18to27.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;
            session.beginTransaction();
//            Student student1 = session.get(Student.class, studentId);
//            session.delete(student1);
            session.createQuery("delete from Student where id=2").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            factory.close();
        }


    }
}
