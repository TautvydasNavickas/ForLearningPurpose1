package com.example.demo.LessonsFrom18to27.ManyToMany.Demo;


import com.example.demo.LessonsFrom18to27.ManyToMany.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourseForStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int id = 6;
            Student student = session.get(Student.class, id);
            Course course = new Course("nerealus");
            Course course1 = new Course("unikumas");

            course.addStudent(student);
            course1.addStudent(student);

            session.save(course);
            session.save(course1);

            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }


    }
}
