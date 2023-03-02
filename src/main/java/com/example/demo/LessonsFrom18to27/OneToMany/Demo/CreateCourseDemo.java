package com.example.demo.LessonsFrom18to27.OneToMany.Demo;

import com.example.demo.LessonsFrom18to27.OneToMany.Entity.Course;
import com.example.demo.LessonsFrom18to27.OneToMany.Entity.Instructor;
import com.example.demo.LessonsFrom18to27.OneToMany.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            Course course = new Course("Super Course");
            Course course1 = new Course("Amazing");

            instructor.add(course);
            instructor.add(course1);

            session.save(course1);
            session.save(course);

            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }


    }
}
