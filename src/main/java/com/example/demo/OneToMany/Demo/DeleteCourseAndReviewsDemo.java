package com.example.demo.OneToMany.Demo;

import com.example.demo.OneToMany.Entity.Course;
import com.example.demo.OneToMany.Entity.Instructor;
import com.example.demo.OneToMany.Entity.InstructorDetail;
import com.example.demo.OneToMany.Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int id = 12;
            Course course = session.get(Course.class, id);

            System.out.println(course);

            session.delete(course);



            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }


    }
}