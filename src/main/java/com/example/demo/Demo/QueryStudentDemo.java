package com.example.demo.Demo;

import com.example.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Student> studentList = session.createQuery("from Student").getResultList();
            extracted(studentList);
            studentList = session.createQuery("from Student stu where stu.lastName='Nobis'").getResultList();
            extracted(studentList);
            studentList = session.createQuery("from Student stu where stu.lastName='Nobis' or stu.lastName='Ministras'").getResultList();
            extracted(studentList);
            studentList = session.createQuery("from Student stu where stu.email like 'puff%'").getResultList();
            extracted(studentList);
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {

            factory.close();
        }


    }

    private static void extracted(List<Student> studentList) {
        for (Student s : studentList){
            System.out.println(s);
        }
    }
}
